package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.OnlinePlayers
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.UpdateOnlinePlayersUseCaseInputPort
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.UpdateOnlinePlayersUseCaseOutputPort

class UpdateOnlinePlayersUseCaseInteractor(private val updateOnlinePlayersUseCaseOutputPort: UpdateOnlinePlayersUseCaseOutputPort): UpdateOnlinePlayersUseCaseInputPort {
    override fun execute(onlinePlayers: OnlinePlayers) {
        updateOnlinePlayersUseCaseOutputPort.handle(onlinePlayers)
    }
}