package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface UpdateOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: List<OnlinePlayer>)
}

interface UpdateOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: List<OnlinePlayer>)
}