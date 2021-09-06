package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

fun interface NewLineUseCaseInputPort {
    fun execute(line: Line)
}

fun interface NewLineUseCaseOutputPort {
    fun handle(line: Line)
}