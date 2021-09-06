package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClient
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClientImpl
import io.grpc.ManagedChannelBuilder
import io.grpc.netty.shaded.io.netty.util.internal.ThreadExecutorMap.apply
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class EnderVisionServiceImpl(
    private val newLineUseCaseInputPort: NewLineUseCaseInputPort,
    private val sendNotificationUseCaseInputPort: SendNotificationUseCaseInputPort,
    private val updateOnlinePlayersUseCaseInputPort: UpdateOnlinePlayersUseCaseInputPort,
    private val channel: ManagedChannelBuilder<*>,
    coroutineContext: CoroutineContext
) :
    EnderVisionService,
    CoroutineScope by CoroutineScope(coroutineContext) {
    private lateinit var flowJob: Job

    private val mutableLineFlow = MutableSharedFlow<Line>()
    private val mutableCommandFlow = MutableSharedFlow<Command>()
    private val mutableNotificationFlow = MutableSharedFlow<Notification>()
    private val mutableOperationFlow = MutableSharedFlow<Operation>()
    private val mutableOnlinePlayersFlow = MutableSharedFlow<OnlinePlayers>()

    private var client: EnderVisionClient? = null

    private var _isConnecting = false
    val isConnecting: Boolean
        get() = _isConnecting

    private fun launchFlow() = launch {
        mutableLineFlow.collect {
            newLineUseCaseInputPort.execute(it)
        }
        mutableNotificationFlow.collect {
            sendNotificationUseCaseInputPort.execute(it)
        }
        mutableOnlinePlayersFlow.collect {
            updateOnlinePlayersUseCaseInputPort.execute(it)
        }
    }

    override fun connect() {
        if (isConnecting) throw IllegalAccessError("Client is now running")

        flowJob = launchFlow()

        client = EnderVisionClientImpl(
            channel = channel.build(),
            mutableLineFlow = mutableLineFlow,
            commandFlow = mutableCommandFlow,
            mutableNotificationFlow = mutableNotificationFlow,
            operationFlow = mutableOperationFlow,
            mutableOnlinePlayersFlow = mutableOnlinePlayersFlow,
            coroutineContext
        )

        client?.apply {
            connectConsole()
            connectManagement()
            connectOnlinePlayers()
        }
    }

    override fun disconnect() {
        client?.close()
        flowJob.cancel()
    }

    override fun sendCommand(command: Command) {
        launch {
            mutableCommandFlow.emit(command)
        }
    }

    override fun sendOperation(operation: Operation) {
        launch {
            mutableOperationFlow.emit(operation)
        }
    }
}

fun EnderVisionServiceImpl(
    host: String,
    port: Int,
    mutableLineSharedFlow: MutableSharedFlow<Line>,
    mutableNotificationSharedFlow: MutableSharedFlow<Notification>,
    mutableOnlinePlayersSharedFlow: MutableSharedFlow<List<OnlinePlayer>>,
    coroutineScope: CoroutineScope,
): EnderVisionServiceImpl {
    val presenter = EnderVisionPresenter(
        mutableLineSharedFlow,
        mutableNotificationSharedFlow,
        mutableOnlinePlayersSharedFlow,
        coroutineContext = coroutineScope.coroutineContext
    )
    return EnderVisionServiceImpl(
        newLineUseCaseInputPort = NewLineUseCaseInteractor(presenter),
        sendNotificationUseCaseInputPort = SendNotificationUseCaseInteractor(presenter),
        updateOnlinePlayersUseCaseInputPort = UpdateOnlinePlayersUseCaseInteractor(presenter),
        channel = ManagedChannelBuilder.forAddress(host, port).apply {
            if (System.getenv("ENDERVISION_USEPLAINTEXT").toBoolean()) usePlaintext()
            keepAliveTime(1000, TimeUnit.MILLISECONDS)
            keepAliveTimeout(5000, TimeUnit.MILLISECONDS)
        },
        coroutineContext = coroutineScope.coroutineContext
    )
}

class EnderVisionPresenter(
    private val mutableLineSharedFlow: MutableSharedFlow<Line>,
    private val mutableOperationFlow: MutableSharedFlow<Notification>,
    private val mutableOnlinePlayersFlow: MutableSharedFlow<OnlinePlayers>,
    coroutineContext: CoroutineContext
) : NewLineUseCaseOutputPort, SendNotificationUseCaseOutputPort, UpdateOnlinePlayersUseCaseOutputPort,
    CoroutineScope by CoroutineScope(coroutineContext) {
    override fun handle(line: Line) {
        launch {
            mutableLineSharedFlow.emit(line)
        }
    }

    override fun handle(notification: Notification) {
        launch {
            mutableOperationFlow.emit(notification)
        }
    }

    override fun handle(onlinePlayers: OnlinePlayers) {
        launch {
            mutableOnlinePlayersFlow.emit(onlinePlayers)
        }
    }
}