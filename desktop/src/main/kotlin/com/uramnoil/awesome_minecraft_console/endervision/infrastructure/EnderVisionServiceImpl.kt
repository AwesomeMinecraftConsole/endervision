package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClient
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionClientImpl
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

data class GrpcSetting(val host: String, val port: UShort, val plaintext: Boolean = false)

class EnderVisionServiceImpl(
    private val newLineUseCaseInputPort: NewLineUseCaseInputPort,
    private val sendNotificationUseCaseInputPort: SendNotificationUseCaseInputPort,
    private val updateOnlinePlayersUseCaseInputPort: UpdateOnlinePlayersUseCaseInputPort,
    setting: GrpcSetting,
    context: CoroutineContext
) : EnderVisionService, CoroutineScope by CoroutineScope(context + Job(context.job)) {
    private val mutableLineFlow = MutableSharedFlow<Line>()
    private val mutableCommandFlow = MutableSharedFlow<Command>()
    private val mutableNotificationFlow = MutableSharedFlow<Notification>()
    private val mutableOperationFlow = MutableSharedFlow<Operation>()
    private val mutableOnlinePlayersFlow = MutableSharedFlow<OnlinePlayers>()

    private val builder = ManagedChannelBuilder
        .forAddress(setting.host, setting.port.toInt())
        .apply {
            if (setting.plaintext) {
                usePlaintext()
            }
        }
        .keepAliveTime(1_000L, TimeUnit.MILLISECONDS)
        .keepAliveTimeout(10_000L, TimeUnit.MILLISECONDS)
        .keepAliveWithoutCalls(true)

    private var client: EnderVisionClient? = null

    private val _isConnecting = MutableStateFlow(false)
    override val isConnecting: StateFlow<Boolean>
        get() = _isConnecting

    private fun launch() {
        launch {
            mutableLineFlow.collect {
                newLineUseCaseInputPort.execute(it)
            }
        }
        launch {
            mutableNotificationFlow.collect {
                sendNotificationUseCaseInputPort.execute(it)
            }
        }
        launch {
            mutableOnlinePlayersFlow.collect {
                updateOnlinePlayersUseCaseInputPort.execute(it)
            }
        }
    }

    override suspend fun connect() {
        // You cannot use `Channel#notifyWhenStateChanged()`.
        // Therefore, the connection state will be changed when this process is finished.

        if (isConnecting.value) return

        val channel = builder.build()
        val client = EnderVisionClientImpl(
            channel = channel,
            mutableLineFlow = mutableLineFlow,
            commandFlow = mutableCommandFlow,
            mutableNotificationFlow = mutableNotificationFlow,
            operationFlow = mutableOperationFlow,
            mutableOnlinePlayersFlow = mutableOnlinePlayersFlow,
            coroutineContext
        )

        launch()
        client.apply {
            connectConsole()
            connectManagement()
            connectOnlinePlayers()
        }

        this.client = client
        _isConnecting.value = true
    }

    override suspend fun disconnect() {
        client?.close()
        coroutineContext.cancelChildren(CancellationException("disconnect"))
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