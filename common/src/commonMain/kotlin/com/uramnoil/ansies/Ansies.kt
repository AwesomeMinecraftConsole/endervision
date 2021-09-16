/**
 * https://www.itu.int/rec/T-REC-T.416/en
 */

package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

val reset: SelectGraphicRendition
    get() = SelectGraphicRendition(startWithReset = ResetOrNormal)

sealed class AsciiCodeOrStringContainer {
    abstract fun build(): String

    data class AsciiCodeContainer(val asciiCode: AsciiCode) : AsciiCodeOrStringContainer() {
        override fun build() = asciiCode.build()
    }

    data class StringContainer(var string: String) : AsciiCodeOrStringContainer() {
        override fun build() = string
    }
}

fun List<AsciiCodeOrStringContainer>.build(): String = map { it.build() }.joinToString("")

fun sgrOf(sgr: SelectGraphicRendition): List<AsciiCodeOrStringContainer> =
    listOf(
        AsciiCodeOrStringContainer.AsciiCodeContainer(
            Escape(
                ControlSequenceIntroducer(
                    sgr
                )
            )
        )
    )

fun sgrOf(parameter: SelectGraphicRenditionParameter): List<AsciiCodeOrStringContainer> = sgrOf(parameter.asSequence())

fun sgrOf(vararg parameters: SelectGraphicRenditionParameter): List<AsciiCodeOrStringContainer> =
    sgrOf(parameters.fold(SelectGraphicRendition()) { acc, selectGraphicRenditionParameter ->
        acc + selectGraphicRenditionParameter
    })

operator fun List<AsciiCodeOrStringContainer>.plus(string: String): List<AsciiCodeOrStringContainer> = apply {
    val lastContainer = last()
    if (lastContainer is AsciiCodeOrStringContainer.StringContainer) {
        lastContainer.string += string
    } else {
        this.toMutableList().add(AsciiCodeOrStringContainer.StringContainer(string))
    }
}

operator fun List<AsciiCodeOrStringContainer>.plus(asciiCode: AsciiCode): List<AsciiCodeOrStringContainer> =
    toMutableList().apply { add(AsciiCodeOrStringContainer.AsciiCodeContainer(asciiCode)) }

operator fun String.plus(list: List<AsciiCodeOrStringContainer>): List<AsciiCodeOrStringContainer> =
    listOf<AsciiCodeOrStringContainer>(AsciiCodeOrStringContainer.StringContainer(this), *list.toTypedArray())

