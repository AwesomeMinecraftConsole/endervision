package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface UpdatedOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: List<OnlinePlayer>)
}

interface UpdatedOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: List<OnlinePlayer>)
}