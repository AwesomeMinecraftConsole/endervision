package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Operation
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendOperationUseCaseInputPort

class OperationController(private val inputPort: SendOperationUseCaseInputPort) {
    fun sendOperation(operation: Operation) {
        inputPort.execute(operation)
    }
}