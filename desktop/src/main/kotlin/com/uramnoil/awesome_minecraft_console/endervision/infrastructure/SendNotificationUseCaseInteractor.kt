package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Notification
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.SendNotificationUseCaseInputPort
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.SendNotificationUseCaseOutputPort

class SendNotificationUseCaseInteractor(private val sendNotificationUseCaseOutputPort: SendNotificationUseCaseOutputPort) :
    SendNotificationUseCaseInputPort {
    override fun execute(notification: Notification) {
        sendNotificationUseCaseOutputPort.handle(notification)
    }
}