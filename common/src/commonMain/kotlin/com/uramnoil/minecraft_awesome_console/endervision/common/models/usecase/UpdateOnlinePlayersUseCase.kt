package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface UpdateOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: OnlinePlayers)
}

interface UpdateOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: OnlinePlayers)
}