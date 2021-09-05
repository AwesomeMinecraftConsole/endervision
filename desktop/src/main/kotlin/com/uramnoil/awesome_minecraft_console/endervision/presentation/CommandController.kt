package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Command
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendCommandUseCaseInputPort

class CommandController(private val inputPort: SendCommandUseCaseInputPort) {
    fun sendCommand(command: String) {
        inputPort.execute(Command(command))
    }
}