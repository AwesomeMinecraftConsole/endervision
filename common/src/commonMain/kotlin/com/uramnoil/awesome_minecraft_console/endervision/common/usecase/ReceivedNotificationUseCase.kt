package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface SendNotificationUseCaseInputPort {
    fun execute(notification: Notification)
}

fun interface SendNotificationUseCaseOutputPort {
    fun handle(notification: Notification)
}