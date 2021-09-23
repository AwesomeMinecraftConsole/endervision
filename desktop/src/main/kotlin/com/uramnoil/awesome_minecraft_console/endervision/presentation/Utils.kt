package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Notification
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayer
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.EnderVisionServiceImpl
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.SendCommandUseCaseInteractor
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.SendOperationUseCaseInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import org.kodein.di.DI
import org.kodein.di.bindSingleton

fun createPresentationModule(host: String, port: Int, coroutineScope: CoroutineScope): DI.Module {
    val mutableLineSharedFlow = MutableSharedFlow<Line>()
    val mutableNotificationSharedFlow = MutableSharedFlow<Notification>()
    val mutableOnlinePlayersSharedFlow = MutableSharedFlow<List<OnlinePlayer>>()

    return DI.Module("presentation", false) {
        bindSingleton {
            LineViewModel(mutableLineSharedFlow)
        }
        bindSingleton {
            NotificationViewModel(mutableNotificationSharedFlow)
        }
        bindSingleton {
            OnlinePlayersViewModel(mutableOnlinePlayersSharedFlow)
        }
        // Hack: Functional Interfaceをファイルに切り分ける
        val enderVisionServiceImplService = EnderVisionServiceImpl(
            host,
            port,
            mutableLineSharedFlow,
            mutableNotificationSharedFlow,
            mutableOnlinePlayersSharedFlow,
            coroutineScope
        )
        enderVisionServiceImplService.connect()

        bindSingleton { CommandController(SendCommandUseCaseInteractor(enderVisionServiceImplService)) }
        bindSingleton { OperationController(SendOperationUseCaseInteractor(enderVisionServiceImplService)) }
    }
}