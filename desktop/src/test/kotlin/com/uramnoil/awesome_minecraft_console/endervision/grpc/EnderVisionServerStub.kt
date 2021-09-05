package com.uramnoil.awesome_minecraft_console.endervision.grpc

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayer
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EnderVisionServerStub(
    private val mutableLineFlow: MutableSharedFlow<String>,
    private val commandFlow: Flow<String>,
    private val mutableNotificationFlow: MutableSharedFlow<String>,
    private val operationFlow: Flow<Operation> = MutableSharedFlow(),
    private val mutableOnlinePlayersFlow: MutableSharedFlow<List<OnlinePlayer>>
) : CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job

    init {
        launch {
            commandFlow.collect {
                Napier.d("[EnderVisionClient]Send a command: $it")
            }
            operationFlow.collect {
                Napier.d("[EnderVisionClient]Send a operation: $it")
            }
        }
    }
}