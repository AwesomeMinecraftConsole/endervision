package com.uramnoil.awesome_minecraft_console.endervision.infrastructure

import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.EnderVisionService
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Operation
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.SendOperationUseCaseInputPort

class SendOperationUseCaseInteractor(private val service: EnderVisionService) : SendOperationUseCaseInputPort {
    override fun execute(operation: Operation) {
        service.sendOperation(operation)
    }
}