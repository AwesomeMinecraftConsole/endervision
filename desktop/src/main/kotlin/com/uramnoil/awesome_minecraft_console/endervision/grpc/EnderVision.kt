package com.uramnoil.awesome_minecraft_console.endervision.grpc

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.*
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Operation.*
import io.grpc.ManagedChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EnderVision(
    private val newLineUseCaseInputPort: NewLineUseCaseInputPort,
    private val sendNotificationUseCaseInputPort: SendNotificationUseCaseInputPort,
    private val updateOnlinePlayersUseCaseInputPort: UpdateOnlinePlayersUseCaseInputPort,
    channel: ManagedChannel
) :
    CoroutineScope, EnderVisionService {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    private val mutableLineFlow = MutableSharedFlow<String>()
    private val mutableCommandFlow = MutableSharedFlow<String>()
    private val mutableNotificationFlow = MutableSharedFlow<String>()
    private val mutableOperationFlow = MutableSharedFlow<Operation>()
    private val mutableOnlinePlayersFlow = MutableSharedFlow<List<OnlinePlayer>>()

    private val client: EnderVisionClient = EnderVisionClientImpl(
        channel = channel,
        mutableLineFlow = mutableLineFlow,
        commandFlow = mutableCommandFlow,
        mutableNotificationFlow = mutableNotificationFlow,
        operationFlow = mutableOperationFlow,
        mutableOnlinePlayersFlow = mutableOnlinePlayersFlow,
        coroutineContext
    )

    fun start() {
        client.apply {
            connectConsole()
            connectManagement()
            connectOnlinePlayers()
        }

        launch {
            mutableLineFlow.collect {
                newLineUseCaseInputPort.execute(it)
            }
            mutableNotificationFlow.collect {
                sendNotificationUseCaseInputPort.execute(Notification(it))
            }
            mutableOnlinePlayersFlow.collect {
                updateOnlinePlayersUseCaseInputPort.execute(OnlinePlayers(it.map { onlinePlayer ->
                    com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.OnlinePlayer(
                        Id(onlinePlayer.id),
                        Name(onlinePlayer.name),
                        Ping(onlinePlayer.ping.toUInt())
                    )
                }))
            }
        }
    }

    override fun sendCommand(command: Command) {
        launch {
            mutableCommandFlow.emit(command.value)
        }
    }

    override fun sendOperation(operation: com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Operation) {
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
) : NewLineUseCaseOutputPort, SendNotificationUseCaseOutputPort, UpdateOnlinePlayersUseCaseOutputPort, CoroutineScope by CoroutineScope(coroutineContext) {
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