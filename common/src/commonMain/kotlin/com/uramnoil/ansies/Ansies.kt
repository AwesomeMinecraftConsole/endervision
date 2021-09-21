/**
 * https://www.itu.int/rec/T-REC-T.416/en
 */

package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

val reset: AsciiControlCharacter
    get() = Escape(ControlSequenceIntroducer(SelectGraphicRendition(startWithReset = ResetOrNormal)))

/**
 * Container to mix ANSI sequence and String.
 */
sealed class AnsiEscapeSequenceOrString {
    abstract fun build(): kotlin.String

    data class AnsiEscapeSequence(val asciiCode: AsciiControlCharacter) :
        AnsiEscapeSequenceOrString() {
        override fun build() = asciiCode.build()
    }

    data class String(var string: kotlin.String) : AnsiEscapeSequenceOrString() {
        override fun build() = string
    }
}

operator fun AnsiEscapeSequenceOrString.plus(right: AnsiEscapeSequenceOrString) =
    AnsiEscapeSequenceOrStringSequence(listOf(this, right))

operator fun AnsiEscapeSequenceOrString.plus(right: String) =
    AnsiEscapeSequenceOrStringSequence(listOf(this, AnsiEscapeSequenceOrString.String(right)))

operator fun AnsiEscapeSequenceOrString.plus(right: AsciiControlCharacter) =
    AnsiEscapeSequenceOrStringSequence(listOf(this, AnsiEscapeSequenceOrString.AnsiEscapeSequence(right)))

operator fun AsciiControlCharacter.plus(right: AnsiEscapeSequenceOrString) =
    AnsiEscapeSequenceOrStringSequence(listOf(AnsiEscapeSequenceOrString.AnsiEscapeSequence(this), right))

operator fun AsciiControlCharacter.plus(right: String) =
    AnsiEscapeSequenceOrStringSequence(
        listOf(
            AnsiEscapeSequenceOrString.AnsiEscapeSequence(this),
            AnsiEscapeSequenceOrString.String(right)
        )
    )

operator fun AsciiControlCharacter.plus(right: AsciiControlCharacter) =
    AnsiEscapeSequenceOrStringSequence(
        listOf(
            AnsiEscapeSequenceOrString.AnsiEscapeSequence(this),
            AnsiEscapeSequenceOrString.AnsiEscapeSequence(right)
        )
    )

class AnsiEscapeSequenceOrStringSequence(asciiCodeOrStringList: List<AnsiEscapeSequenceOrString>) {
    private val mutableAsciiCodeOrStringList: MutableList<AnsiEscapeSequenceOrString> =
        asciiCodeOrStringList.toMutableList()
    val asciiCodeOrStringList: List<AnsiEscapeSequenceOrString>
        get() = mutableAsciiCodeOrStringList

    fun build(): String = asciiCodeOrStringList.map { it.build() }.joinToString("")

    operator fun plus(string: String) = apply {
        val lastContainer = asciiCodeOrStringList.last()
        if (lastContainer is AnsiEscapeSequenceOrString.String) {
            lastContainer.string += string
        } else {
            mutableAsciiCodeOrStringList.add(AnsiEscapeSequenceOrString.String(string))
        }
    }

    operator fun plus(asciiCode: AsciiControlCharacter) =
        apply { mutableAsciiCodeOrStringList.add(AnsiEscapeSequenceOrString.AnsiEscapeSequence(asciiCode)) }


    operator fun plus(sequence: AnsiEscapeSequenceOrString) =
        apply { mutableAsciiCodeOrStringList.add(sequence) }

    operator fun plus(sequence: AnsiEscapeSequenceOrStringSequence) =
        apply { mutableAsciiCodeOrStringList.addAll(sequence.asciiCodeOrStringList) }
}

operator fun String.plus(sequence: AnsiEscapeSequenceOrStringSequence): AnsiEscapeSequenceOrStringSequence =
    AnsiEscapeSequenceOrStringSequence(
        listOf(
            AnsiEscapeSequenceOrString.String(this),
            *sequence.asciiCodeOrStringList.toTypedArray()
        )
    )

data class Span(val sgr: SelectGraphicRendition, var string: String = "")

fun List<AnsiEscapeSequenceOrString>.toSpans(): List<Span> {
    val mutableList = mutableListOf<Span>()

    forEach {
        when (it) {
            is AnsiEscapeSequenceOrString.AnsiEscapeSequence -> {
                if (
                    it.asciiCode is Escape
                    && it.asciiCode.parameter is ControlSequenceIntroducer
                    && it.asciiCode.parameter.parameter is SelectGraphicRendition
                ) {
                    mutableList.add(Span(it.asciiCode.parameter.parameter))
                }
            }
            is AnsiEscapeSequenceOrString.String -> {
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
