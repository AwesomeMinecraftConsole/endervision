package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

fun interface SendNotificationUseCaseInputPort {
    fun execute(notification: Notification)
}

fun interface SendNotificationUseCaseOutputPort {
    fun handle(notification: Notification)
}