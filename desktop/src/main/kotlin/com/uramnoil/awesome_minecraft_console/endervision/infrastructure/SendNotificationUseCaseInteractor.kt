package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Notification
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendNotificationUseCaseInputPort
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendNotificationUseCaseOutputPort

class SendNotificationUseCaseInteractor(private val sendNotificationUseCaseOutputPort: SendNotificationUseCaseOutputPort) : SendNotificationUseCaseInputPort{
    override fun execute(notification: Notification) {
        sendNotificationUseCaseOutputPort.handle(notification)
    }
}