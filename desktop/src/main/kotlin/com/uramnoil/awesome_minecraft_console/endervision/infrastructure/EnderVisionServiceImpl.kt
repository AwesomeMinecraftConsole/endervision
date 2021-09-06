package com.uramnoil.awesome_minecraft_console.endervision.grpc

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayer
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Operation.Start
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EnderVisionServiceImpl(
    private val newLineUseCaseInputPort: NewLineUseCaseInputPort,
    private val sendNotificationUseCaseInputPort: SendNotificationUseCaseInputPort,
    private val updateOnlinePlayersUseCaseInputPort: UpdateOnlinePlayersUseCaseInputPort,
    private val channel: ManagedChannelBuilder<*>
) :
    CoroutineScope, EnderVisionService {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job

    private lateinit var flowJob: Job

    private val mutableLineFlow = MutableSharedFlow<String>()
    private val mutableCommandFlow = MutableSharedFlow<String>()
    private val mutableNotificationFlow = MutableSharedFlow<String>()
    private val mutableOperationFlow = MutableSharedFlow<Operation>()
    private val mutableOnlinePlayersFlow = MutableSharedFlow<List<com.uramnoil.awesome_minecraft_console.endervision.grpc.OnlinePlayer>>()

    private var client: EnderVisionClient? = null

    private var _isConnecting = false
    val isConnecting: Boolean
        get() = _isConnecting

    private fun launchFlow() = launch {
        mutableLineFlow.collect {
            newLineUseCaseInputPort.execute(it)
        }
        mutableNotificationFlow.collect {
            sendNotificationUseCaseInputPort.execute(Notification(it))
        }
        mutableOnlinePlayersFlow.collect {
            updateOnlinePlayersUseCaseInputPort.execute(OnlinePlayers(it.map { onlinePlayer ->
                OnlinePlayer(
                    Id(onlinePlayer.id),
                    Name(onlinePlayer.name),
                    Ping(onlinePlayer.ping.toUInt())
                )
            }))
        }
    }

    override fun connect() {
        if (!isConnecting) throw IllegalAccessError("Client is now running")

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
            mutableCommandFlow.emit(command.value)
        }
    }

    override fun sendOperation(operation: com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Operation) {
        launch {
            mutableOperationFlow.emit(
                when (operation) {
                    Start -> Operation.Start
                }
            )
        }
    }
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