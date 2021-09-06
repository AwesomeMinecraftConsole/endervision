package com.uramnoil.awesome_minecraft_console.endervision.grpc

import awesome_minecraft_console.endervision.EnderVisionGrpcKt
import awesome_minecraft_console.weaver.WeaverOuterClass
import com.google.protobuf.Empty
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import io.grpc.ManagedChannel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

interface EnderVisionClient : Closeable {
    fun connectConsole()
    fun connectManagement()
    fun connectOnlinePlayers()
}



class EnderVisionClientImpl(
    private val channel: ManagedChannel,
    private val mutableLineFlow: MutableSharedFlow<Line>,
    private val commandFlow: Flow<Command>,
    private val mutableNotificationFlow: MutableSharedFlow<Notification>,
    private val operationFlow: Flow<Operation>,
    private val mutableOnlinePlayersFlow: MutableSharedFlow<OnlinePlayers>,
    private val parent: CoroutineContext
) : EnderVisionClient, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = parent + CoroutineExceptionHandler { _, throwable ->
            if (throwable is CancellationException) {
                close()
            }
        }

    private val stub = EnderVisionGrpcKt.EnderVisionCoroutineStub(channel)

    override fun connectConsole() {
        launch {
            stub.console(commandFlow.map { WeaverOuterClass.Command.newBuilder().setCommand(it.value).build() }).collect {
                mutableLineFlow.emit(Line(it.line))
            }
        }
    }

    override fun connectManagement() {
        launch {
            stub.management(operationFlow.map {
                val type = when (it) {
                    Operation.Start -> WeaverOuterClass.Operation.Type.OPERATION_START
                }
                WeaverOuterClass.Operation.newBuilder().setOperation(type).build()
            }).collect {
                mutableNotificationFlow.emit(Notification(it.notification))
            }
        }
    }

    override fun connectOnlinePlayers() {
        launch {
            stub.onlinePlayers(Empty.newBuilder().build()).collect {
                mutableOnlinePlayersFlow.emit(it.onlinePlayersList.map { onlinePlayer ->
                    OnlinePlayer(onlinePlayer.id, onlinePlayer.name, onlinePlayer.ping.toUInt())
                })
            }
        }
    }

    override fun close() {
        channel.shutdown()
    }
}