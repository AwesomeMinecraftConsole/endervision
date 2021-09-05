package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

interface SendOperationUseCaseInputPort {
    fun execute(operation: Operation)
}

interface SendOperationUseCaseOutputPort {
    fun handle(operation: Operation)
}