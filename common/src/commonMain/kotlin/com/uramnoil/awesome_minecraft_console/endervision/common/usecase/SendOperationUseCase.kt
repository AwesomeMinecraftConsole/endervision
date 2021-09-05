package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface SendOperationUseCaseInputPort {
    fun execute(operation: Operation)
}

fun interface SendOperationUseCaseOutputPort {
    fun handle(operation: Operation)
}