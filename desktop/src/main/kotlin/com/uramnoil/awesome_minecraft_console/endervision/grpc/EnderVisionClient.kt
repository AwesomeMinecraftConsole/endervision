package com.uramnoil.awesome_minecraft_console.endervision.grpc

import awesome_minecraft_console.endervision.EnderVisionGrpcKt
import awesome_minecraft_console.weaver.WeaverOuterClass
import com.google.protobuf.Empty
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import io.grpc.ConnectivityState
import io.grpc.ManagedChannel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

interface EnderVisionClient {
    suspend fun connectConsole()
    suspend fun connectManagement()
    suspend fun connectOnlinePlayers()
    suspend fun close()
}

class EnderVisionClientImpl(
    private val channel: ManagedChannel,
    private val mutableLineFlow: MutableSharedFlow<Line>,
    private val commandFlow: Flow<Command>,
    private val mutableNotificationFlow: MutableSharedFlow<Notification>,
    private val operationFlow: Flow<Operation>,
    private val mutableOnlinePlayersFlow: MutableSharedFlow<OnlinePlayers>,
    context: CoroutineContext
) : EnderVisionClient, CoroutineScope by CoroutineScope(context + Job(context.job)) {
    private val stub = EnderVisionGrpcKt.EnderVisionCoroutineStub(channel).withWaitForReady()

    private suspend fun joinReady() {
        if (channel.getState(true) != ConnectivityState.READY) {
            suspendCoroutine<Unit> {
                channel.notifyWhenStateChanged(ConnectivityState.READY) {
                    it.resume(Unit)
                }
            }
        }
    }

    override suspend fun connectConsole() {
        joinReady()
        launch {
            stub.console(commandFlow.map { WeaverOuterClass.Command.newBuilder().setCommand(it.value).build() })
                .collect {
                    mutableLineFlow.emit(Line(it.line))
                }
        }
    }

    override suspend fun connectManagement() {
        joinReady()
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

    override suspend fun connectOnlinePlayers() {
        joinReady()
        launch {
            stub.onlinePlayers(Empty.newBuilder().build()).collect {
                mutableOnlinePlayersFlow.emit(it.onlinePlayersList.map { onlinePlayer ->
                    OnlinePlayer(onlinePlayer.id, onlinePlayer.name, onlinePlayer.ping.toUInt())
                })
            }
        }
    }

    override suspend fun close() {
        withContext(Dispatchers.Default) {
            channel.awaitTermination(5_000L, TimeUnit.MILLISECONDS)
        }
    }
}