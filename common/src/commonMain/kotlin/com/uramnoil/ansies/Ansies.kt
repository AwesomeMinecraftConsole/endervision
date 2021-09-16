/**
 * https://www.itu.int/rec/T-REC-T.416/en
 */

package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*
import com.uramnoil.ansies.parameter.AsciiCode

val reset: SelectGraphicRenditionSequence
    get() = SelectGraphicRenditionSequence(startWithReset = ResetOrNormal)

/**
 *
 */
class SelectGraphicRenditionSequence(
    private val override: Boolean = false,
    startWithReset: ResetOrNormal? = null,
    intensity: Intensity? = null,
    penmanship: Penmanship? = null,
    font: Font? = null,
    blink: Blink? = null,
    conceal: Conceal? = null,
    crossedOut: CrossOut? = null,
    foregroundColor: ForegroundColor? = null,
    backgroundColor: BackgroundColor? = null,
    underline: Underline? = null,
    reverse: Reverse? = null,
    emojiVariation: EmojiVariation? = null,
    overline: Overline? = null,
    underlineColor: UnderLineColor? = null,
    ideogram: Ideogram? = null,
    script: Script? = null,
    brightForegroundColor: BrightForegroundColor? = null,
    brightBackgroundColor: BrightBackgroundColor? = null,
) {
    var startWithReset = startWithReset
        internal set
    var intensity = intensity
        internal set
    var penmanship = penmanship
        internal set
    var blink = blink
        internal set
    var conceal = conceal
        internal set
    var crossedOut = crossedOut
        internal set
    var font = font
        internal set
    var foregroundColor = foregroundColor
        internal set
    var backgroundColor = backgroundColor
        internal set
    var underline = underline
        internal set
    var underlineColor = underlineColor
        internal set
    var reverse = reverse
        internal set
    var emojiVariation = emojiVariation
        internal set
    var overline = overline
        internal set
    var ideogram = ideogram
        internal set
    var script = script
        internal set
    var brightForegroundColor = brightForegroundColor
        internal set
    var brightBackgroundColor = brightBackgroundColor
        internal set

    /**
     * Construct a SelectGraphicRenditionSequence and change it to a String.
     * The order of the sequence is roughly based on the ascending order of each parameter's number.
     *
     * 1. Reset (0)
     * 1. Intensity
     *      - BoldOrIncreasedIntensity (1)
     *      - Faint, decreased intensity or second colour (2)
     *      　NormalIntensity (22)
     * 1. Penmanship
     *      - Italicized
     *      - Fraktur
     *      - ResetPenmanship (23)
     * 1. Underline
     *      - Underlined (4)
     *      - DoublyUnderlined (21)
     *      - NotUnderlined (24)
     * 1. Blink
     *      - SlowlyBlinking (5)
     *      - RapidlyBlinking (6)
     *      - NotBlinking (25)
     * 1. Reverse
     *      - Reversed (7)
     *      - NotReversed (27)
     * 1. Conceal
     *      - Concealed (8)
     *      - Revealed (28)
     * 1. CrossedOut
     *      - CrossedOut (9)
     *      - NotCrossedOut (29)
     * 1. ForegroundColor
     *      - ForegroundColor (30-37)
     *      - SelectForegroundColor (38)
     *      - DefaultForegroundColor (39)
     * 1. BackgroundColor
     *      - BackgroundColor (40-47)
     *      - SelectBackgroundColor (48)
     *      - DefaultBackgroundColor (49)
     * 1. EmojiVariation
     *      - Framed (51)
     *      - Encircled (52)
     *      - ResetEmojiVariation(54)
     * 1. Overline
     *      - Overlined (53)
     *      - NotOverlined(55)
     * 1. UnderlineColor
     *      - SelectUnderlineColor (58)
     *      - DefaultUnderlineColor (59)
     * 1. Ideogram
     *      - IdeogramUnderlineOrRightSideLine (60)
     *      - IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide (61)
     *      - IdeogramOverlineOrLeftSideLine (62)
     *      - IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide (63)
     *      - IdeogramStressMarking (64)
     *      - NoIdeogramAttribute (65)
     * 1. Script
     *      - Superscript (73)
     *      - Subscript (74)
     *      - NoScriptAttribute
     * 1. BrightForegroundColor
     *      - BrightForegroundColor (90-98)
     * 1. BrightBackgroundColor
     *      - BrightBackgroundColor (100-107)
     */
    fun build(): String = Escape(
        ControlSequenceIntroducer(
            SelectGraphicRendition(
                mutableSetOf(
                    startWithReset,
                    intensity,
                    underline,
                    penmanship,
                    blink,
                    reverse,
                    conceal,
                    crossedOut,
                    foregroundColor,
                    backgroundColor,
                    emojiVariation,
                    overline,
                    underlineColor,
                    ideogram,
                    script,
                    brightForegroundColor,
                    brightBackgroundColor,
                ).filterNotNull().toSet()
            )
        )
    ).build()
}

fun SelectGraphicRenditionSequence.basedOn(base: SelectGraphicRenditionSequence) = apply {
    if (intensity == null) {
        intensity = base.intensity
    }
    if (blink == null) {
        blink = base.blink
    }
    if (reverse == null) {
        reverse = base.reverse
    }
    if (conceal == null) {
        conceal = base.conceal
    }
    if (crossedOut == null) {
        crossedOut = base.crossedOut
    }
    if (foregroundColor == null) {
        foregroundColor = base.foregroundColor
    }
    if (backgroundColor == null) {
        backgroundColor = base.backgroundColor
    }
    if (underline == null) {
        underline = base.underline
    }
    if (underlineColor == null) {
        underlineColor = base.underlineColor
    }
    if (emojiVariation == null) {
        emojiVariation = base.emojiVariation
    }
    if (overline == null) {
        overline = base.overline
    }
    if (ideogram == null) {
        ideogram = base.ideogram
    }
    if (script == null) {
        script = base.script
    }
    if (brightForegroundColor == null) {
        brightForegroundColor = base.brightForegroundColor
    }
    if (brightBackgroundColor == null) {
        brightBackgroundColor = base.brightBackgroundColor
    }
}

/**
 * AsciiCode的に普通の文字列はSGRシーケンスの一部と考える。
 * AsciiCodeと文字列で分けることはしない。
 */
data class SelectGraphicRenditionSequenceAndString(
    val builder: SelectGraphicRenditionSequence? = null,
    var string: String = ""
) {
    fun build(): String = (builder?.build() ?: "") + string
}

fun List<SelectGraphicRenditionSequenceAndString>.build(): String = map{ it.build() }.joinToString("")

fun sgrOf(sequence: SelectGraphicRenditionSequence) = listOf(SelectGraphicRenditionSequenceAndString(sequence))

fun sgrOf(parameter: SelectGraphicRenditionParameter) = listOf(SelectGraphicRenditionSequenceAndString(parameter.asSequence()))

fun sgrOf(vararg parameters: SelectGraphicRenditionParameter) =
    parameters.fold(SelectGraphicRenditionSequence()) { acc, selectGraphicRenditionParameter ->
        acc + selectGraphicRenditionParameter
    }

operator fun List<SelectGraphicRenditionSequenceAndString>.plus(string: String) = apply { this.last().string += string }

operator fun List<SelectGraphicRenditionSequenceAndString>.plus(sequence: SelectGraphicRenditionSequence): List<SelectGraphicRenditionSequenceAndString> =
    toMutableList().apply { add(SelectGraphicRenditionSequenceAndString(sequence)) }

operator fun String.plus(list: List<SelectGraphicRenditionSequenceAndString>): List<SelectGraphicRenditionSequenceAndString> =
    listOf(SelectGraphicRenditionSequenceAndString(string = this), *list.toTypedArray())

