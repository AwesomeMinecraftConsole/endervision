package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayers
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.UpdateOnlinePlayersUseCaseInputPort
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.UpdateOnlinePlayersUseCaseOutputPort

class UpdateOnlinePlayersUseCaseInteractor(private val updateOnlinePlayersUseCaseOutputPort: UpdateOnlinePlayersUseCaseOutputPort):
    UpdateOnlinePlayersUseCaseInputPort {
    override fun execute(onlinePlayers: OnlinePlayers) {
        updateOnlinePlayersUseCaseOutputPort.handle(onlinePlayers)
    }
}