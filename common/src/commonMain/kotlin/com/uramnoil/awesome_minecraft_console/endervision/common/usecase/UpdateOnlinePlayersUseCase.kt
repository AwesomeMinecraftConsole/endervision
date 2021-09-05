package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface UpdateOnlinePlayersUseCaseInputPort {
    fun execute(onlinePlayers: OnlinePlayers)
}

fun interface UpdateOnlinePlayersUseCaseOutputPort {
    fun handle(onlinePlayers: OnlinePlayers)
}