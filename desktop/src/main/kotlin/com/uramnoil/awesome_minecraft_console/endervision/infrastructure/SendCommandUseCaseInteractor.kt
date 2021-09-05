package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.models.usecase.Command
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionService
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.SendCommandUseCaseInputPort

class SendCommandUseCaseInteractor(val service: EnderVisionService) : SendCommandUseCaseInputPort {
    override fun execute(command: Command) {
        service.sendCommand(command)
    }
}