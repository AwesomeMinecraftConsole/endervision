package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Notification
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayer
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.*
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.flow.MutableSharedFlow
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

fun createPresentationModule(host: String, port: UShort, context: CoroutineContext): DI {
    val mutableLineSharedFlow = MutableSharedFlow<Line>()
    val mutableNotificationSharedFlow = MutableSharedFlow<Notification>()
    val mutableOnlinePlayersSharedFlow = MutableSharedFlow<List<OnlinePlayer>>()

    return DI {
        bindSingleton {
            LineViewModel(mutableLineSharedFlow)
        }
        bindSingleton {
            NotificationViewModel(mutableNotificationSharedFlow)
        }
        bindSingleton {
            OnlinePlayersViewModel(mutableOnlinePlayersSharedFlow)
        }

        bindSingleton {
            val presenter = EnderVisionPresenter(
                mutableLineSharedFlow,
                mutableNotificationSharedFlow,
                mutableOnlinePlayersSharedFlow,
                context
            )
            EnderVisionServiceImpl(
                newLineUseCaseInputPort = NewLineUseCaseInteractor(presenter),
                sendNotificationUseCaseInputPort = SendNotificationUseCaseInteractor(presenter),
                updateOnlinePlayersUseCaseInputPort = UpdateOnlinePlayersUseCaseInteractor(presenter),
                ManagedChannelBuilder.forAddress(host, port.toInt())
                    .usePlaintext()
                    .keepAliveTime(1_000L, TimeUnit.MILLISECONDS)
                    .keepAliveTimeout(20_000L, TimeUnit.MILLISECONDS)
                    .build(),
                context
            )
        }


        bindSingleton { CommandController(SendCommandUseCaseInteractor(instance())) }
        bindSingleton { OperationController(SendOperationUseCaseInteractor(instance())) }
    }
}