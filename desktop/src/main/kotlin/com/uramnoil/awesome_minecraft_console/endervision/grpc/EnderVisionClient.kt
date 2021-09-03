package com.uramnoil.awesome_minecraft_console.endervision.grpc

import awesome_minecraft_console.endervision.EnderVisionGrpcKt
import awesome_minecraft_console.weaver.WeaverOuterClass
import com.google.protobuf.Empty
import io.grpc.ManagedChannel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

enum class Operation {
    Start,
}

class EnderVisionClient(
    channel: ManagedChannel,
    private val mutableLineFlow: MutableSharedFlow<String>,
    private val commandFlow: Flow<String>,
    private val mutableNotificationFlow: MutableSharedFlow<String>,
    private val operationFlow: Flow<Operation> = MutableSharedFlow(),
    private val mutableOnlinePlayersFlow: MutableSharedFlow<List<OnlinePlayer>>
) : Closeable, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

    private val stub = EnderVisionGrpcKt.EnderVisionCoroutineStub(channel)

    override fun close() {
        job.complete()
    }

    fun connectConsole() = launch {
        stub.console(commandFlow.map { WeaverOuterClass.Command.newBuilder().setCommand(it).build() }).collect {
            mutableLineFlow.emit(it.line)
        }
    }

    fun connectManagement() = launch {
        stub.management(operationFlow.map {
            val type = when (it) {
                Operation.Start -> WeaverOuterClass.Operation.Type.OPERATION_START
            }
            WeaverOuterClass.Operation.newBuilder().setOperation(type).build()
        }).collect {
            mutableNotificationFlow.emit(it.notification)
        }
    }

    fun connectOnlinePlayers() = launch {
        stub.onlinePlayers(Empty.newBuilder().build()).collect {
            mutableOnlinePlayersFlow.emit(it.onlinePlayersList.map { onlinePlayer ->
                OnlinePlayer(onlinePlayer.id, onlinePlayer.name, onlinePlayer.ping.toUInt())
            })
        }
    }
}