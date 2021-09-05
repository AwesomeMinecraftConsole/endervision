package com.uramnoil.awesome_minecraft_console.endervision.grpc

import awesome_minecraft_console.endervision.EnderVisionGrpcKt
import awesome_minecraft_console.weaver.WeaverOuterClass
import com.google.protobuf.Empty
import com.uramnoil.awesome_minecraft_console.endervision.grpc.Operation.*
import io.grpc.ManagedChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

data class OnlinePlayer(val id: String, val name: String, val ping: Int)
enum class Operation(id: Int) {
    Start(0),
    Unrecognized(-1),
}

interface EnderVisionClient : Closeable {
    fun connectConsole()
    fun connectManagement()
    fun connectOnlinePlayers()
}

class EnderVisionClientImpl(
    channel: ManagedChannel,
    private val mutableLineFlow: MutableSharedFlow<String>,
    private val commandFlow: Flow<String>,
    private val mutableNotificationFlow: MutableSharedFlow<String>,
    private val operationFlow: Flow<Operation> = MutableSharedFlow(),
    private val mutableOnlinePlayersFlow: MutableSharedFlow<List<OnlinePlayer>>,
    coroutineContext: CoroutineContext
) : EnderVisionClient, CoroutineScope by CoroutineScope(coroutineContext) {
    private val stub = EnderVisionGrpcKt.EnderVisionCoroutineStub(channel)

    override fun connectConsole() {
        launch {
            stub.console(commandFlow.map { WeaverOuterClass.Command.newBuilder().setCommand(it).build() }).collect {
                mutableLineFlow.emit(it.line)
            }
        }
    }

    override fun connectManagement() {
        launch {
            stub.management(operationFlow.map {
                val type = when (it) {
                    Start -> WeaverOuterClass.Operation.Type.OPERATION_START
                    Unrecognized -> WeaverOuterClass.Operation.Type.UNRECOGNIZED
                }
                WeaverOuterClass.Operation.newBuilder().setOperation(type).build()
            }).collect {
                mutableNotificationFlow.emit(it.notification)
            }
        }
    }

    override fun connectOnlinePlayers() {
        launch {
            stub.onlinePlayers(Empty.newBuilder().build()).collect {
                mutableOnlinePlayersFlow.emit(it.onlinePlayersList.map { onlinePlayer ->
                    OnlinePlayer(onlinePlayer.id, onlinePlayer.name, onlinePlayer.ping)
                })
            }
        }
    }

    override fun close() {}
}