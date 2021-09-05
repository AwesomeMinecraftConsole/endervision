package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionService
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Operation
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.SendOperationUseCaseInputPort

class SendOperationUseCaseInteractor(private val service: EnderVisionService) : SendOperationUseCaseInputPort {
    override fun execute(operation: Operation) {
        service.sendOperation(operation)
    }
}