package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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