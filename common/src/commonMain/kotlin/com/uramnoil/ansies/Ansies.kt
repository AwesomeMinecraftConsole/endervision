/**
 * https://www.itu.int/rec/T-REC-T.416/en
 */

package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

val reset: AsciiCode
    get() = Escape(ControlSequenceIntroducer(SelectGraphicRendition(startWithReset = ResetOrNormal)))

/**
 * Container to mix ANSI sequence and String.
 */
sealed class AsciiCodeOrString {
    abstract fun build(): kotlin.String

    data class AsciiCode(val asciiCode: com.uramnoil.ansies.parameter.AsciiCode) : AsciiCodeOrString() {
        override fun build() = asciiCode.build()
    }

    data class String(var string: kotlin.String) : AsciiCodeOrString() {
        override fun build() = string
    }
}

class AsciiCodeOrStringSequence(asciiCodeOrStringList: List<AsciiCodeOrString>) {
    private val mutableAsciiCodeOrStringList: MutableList<AsciiCodeOrString> = asciiCodeOrStringList.toMutableList()
    val asciiCodeOrStringList: List<AsciiCodeOrString>
        get() = mutableAsciiCodeOrStringList

    fun build(): String = asciiCodeOrStringList.map { it.build() }.joinToString("")

    operator fun plus(sgr: SelectGraphicRendition) = mutableAsciiCodeOrStringList.add(AsciiCodeOrString.AsciiCode(Escape(ControlSequenceIntroducer(sgr))))

    operator fun plus(string: String) = apply {
        val lastContainer = asciiCodeOrStringList.last()
        if (lastContainer is AsciiCodeOrString.String) {
            lastContainer.string += string
        } else {
            mutableAsciiCodeOrStringList.add(AsciiCodeOrString.String(string))
        }
    }

    operator fun plus(asciiCode: AsciiCode) = apply { mutableAsciiCodeOrStringList.add(AsciiCodeOrString.AsciiCode(asciiCode)) }
}

operator fun String.plus(sequence: AsciiCodeOrStringSequence): AsciiCodeOrStringSequence =
    AsciiCodeOrStringSequence(listOf(AsciiCodeOrString.String(this), *sequence.asciiCodeOrStringList.toTypedArray()))

data class Span(val sgr: SelectGraphicRendition, var string: String = "")

fun List<AsciiCodeOrString>.toSpans(): List<Span> {
    val mutableList = mutableListOf<Span>()

    forEach {
        when (it) {
            is AsciiCodeOrString.AsciiCode -> {
                if (
                    it.asciiCode is Escape
                    && it.asciiCode.parameter is ControlSequenceIntroducer
                    && it.asciiCode.parameter.parameter is SelectGraphicRendition
                ) {
                    mutableList.add(Span(it.asciiCode.parameter.parameter))
                }
            }
            is AsciiCodeOrString.String -> {
                mutableList.lastOrNull()?.let { last -> last.string += it.string }
                    ?: mutableList.add(Span(SelectGraphicRendition(), it.string))
            }
        }
    }

    // The SGR of each span inherits attributes of SRG of previous span.
    mutableList.fold(SelectGraphicRendition()) { acc, span ->
        span.sgr.basedOn(acc)
        span.sgr.copy()
    }

    return mutableList
}
