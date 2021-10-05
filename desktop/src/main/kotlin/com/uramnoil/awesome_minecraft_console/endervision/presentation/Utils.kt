package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionConnectionController
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Notification
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayer
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.coroutines.CoroutineContext

data class Presentations(
    val viewModel: LineViewModel,
    val notificationViewModel: NotificationViewModel,
    val onlinePlayersViewModel: OnlinePlayersViewModel,
    val enderVisionService: EnderVisionConnectionController,
    val commandController: CommandController,
    val operationController: OperationController
)

fun createServerPresentations(host: String, port: UShort, connectionContext: CoroutineContext): Presentations {
    val mutableLineSharedFlow = MutableSharedFlow<Line>()
    val mutableNotificationSharedFlow = MutableSharedFlow<Notification>()
    val mutableOnlinePlayersSharedFlow = MutableSharedFlow<List<OnlinePlayer>>()

    val lineViewModel = LineViewModel(mutableLineSharedFlow)
    val notificationViewModel = NotificationViewModel(mutableNotificationSharedFlow)
    val onlinePlayersViewModel = OnlinePlayersViewModel(mutableOnlinePlayersSharedFlow)

    val presenter = EnderVisionPresenter(
        mutableLineSharedFlow,
        mutableNotificationSharedFlow,
        mutableOnlinePlayersSharedFlow,
        connectionContext
    )
    val enderVisionService = EnderVisionServiceImpl(
        newLineUseCaseInputPort = NewLineUseCaseInteractor(presenter),
        sendNotificationUseCaseInputPort = SendNotificationUseCaseInteractor(presenter),
        updateOnlinePlayersUseCaseInputPort = UpdateOnlinePlayersUseCaseInteractor(presenter),
        GrpcSetting(host, port, true),
        connectionContext
    )

    val enderVisionConnectionController: EnderVisionConnectionController =
        EnderVisionConnectionControllerImpl(enderVisionService)
    val commandController = CommandController(SendCommandUseCaseInteractor(enderVisionService))
    val operationController = OperationController(SendOperationUseCaseInteractor(enderVisionService))

    return Presentations(
        lineViewModel,
        notificationViewModel,
        onlinePlayersViewModel,
        enderVisionConnectionController,
        commandController,
        operationController
    )
}