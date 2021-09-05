package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

fun interface NewLineUseCaseInputPort {
    fun execute(line: String)
}

fun interface NewLineUseCaseOutputPort {
    fun handle(line: Line)
}