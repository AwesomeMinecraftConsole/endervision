package com.uramnoil.awesome_minecraft_console.endervision.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Operation
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.SendOperationUseCaseInputPort

class OperationController(private val inputPort: SendOperationUseCaseInputPort) {
    fun sendOperation(operation: Operation) {
        inputPort.execute(operation)
    }
}