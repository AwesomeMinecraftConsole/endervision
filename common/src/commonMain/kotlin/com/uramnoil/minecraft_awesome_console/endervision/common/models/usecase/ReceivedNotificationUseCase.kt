package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface SendNotificationUseCaseInputPort {
    fun execute(notification: String)
}

interface SendNotificationUseCaseOutputPort {
    fun handle(notification: String)
}