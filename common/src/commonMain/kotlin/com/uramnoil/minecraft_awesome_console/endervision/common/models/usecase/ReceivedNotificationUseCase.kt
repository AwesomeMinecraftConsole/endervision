package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface SendNotificationUseCaseInputPort {
    fun execute(notification: Notification)
}

interface SendNotificationUseCaseOutputPort {
    fun handle(notification: Notification)
}