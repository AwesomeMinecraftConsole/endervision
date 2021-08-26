package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

data class OnlinePlayer(val id: String, val name: String, val ping: Int)

interface UpdatedOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: List<OnlinePlayer>)
}

interface UpdatedOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: List<OnlinePlayer>)
}