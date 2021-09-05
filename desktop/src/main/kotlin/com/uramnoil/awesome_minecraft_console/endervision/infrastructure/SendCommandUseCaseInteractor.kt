package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Command
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.EnderVisionService
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendCommandUseCaseInputPort

class SendCommandUseCaseInteractor(val service: EnderVisionService) : SendCommandUseCaseInputPort {
    override fun execute(command: Command) {
        service.sendCommand(command)
    }
}