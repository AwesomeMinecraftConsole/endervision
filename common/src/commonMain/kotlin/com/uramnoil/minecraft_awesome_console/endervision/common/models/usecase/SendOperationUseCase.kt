package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

fun interface SendOperationUseCaseInputPort {
    fun execute(operation: Operation)
}

fun interface SendOperationUseCaseOutputPort {
    fun handle(operation: Operation)
}