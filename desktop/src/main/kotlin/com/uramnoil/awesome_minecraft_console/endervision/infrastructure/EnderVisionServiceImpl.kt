package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClient
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClientImpl
import io.grpc.ManagedChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EnderVisionServiceImpl(
    private val newLineUseCaseInputPort: NewLineUseCaseInputPort,
    private val sendNotificationUseCaseInputPort: SendNotificationUseCaseInputPort,
    private val updateOnlinePlayersUseCaseInputPort: UpdateOnlinePlayersUseCaseInputPort,
    private val channel: ManagedChannel,
    context: CoroutineContext
) : EnderVisionService, CoroutineScope by CoroutineScope(context) {
    private val mutableLineFlow = MutableSharedFlow<Line>()
    private val mutableCommandFlow = MutableSharedFlow<Command>()
    private val mutableNotificationFlow = MutableSharedFlow<Notification>()
    private val mutableOperationFlow = MutableSharedFlow<Operation>()
    private val mutableOnlinePlayersFlow = MutableSharedFlow<OnlinePlayers>()

    private var client: EnderVisionClient? = null

    private var _isConnecting = MutableStateFlow(false)
    override val isConnecting: StateFlow<Boolean>
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

    override suspend fun connect() {
        if (isConnecting.value) throw IllegalAccessError("Client is now running")

        launchFlow()

        client = EnderVisionClientImpl(
            channel = channel,
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
        _isConnecting.value = false
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