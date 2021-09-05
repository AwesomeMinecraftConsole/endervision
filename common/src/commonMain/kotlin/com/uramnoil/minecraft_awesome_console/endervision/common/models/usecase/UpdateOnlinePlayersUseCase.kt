package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

fun interface UpdateOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: OnlinePlayers)
}

fun interface UpdateOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: OnlinePlayers)
}