/**
 * https://www.itu.int/rec/T-REC-T.416/en
 */

package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

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

fun SelectGraphicRenditionSequence.startWithReset(): SelectGraphicRenditionSequence =
    apply { startWithReset = ResetOrNormal }

fun SelectGraphicRenditionSequence.black(): SelectGraphicRenditionSequence =
    apply { foregroundColor = BlackForeground }

fun SelectGraphicRenditionSequence.red(): SelectGraphicRenditionSequence =
    apply { foregroundColor = RedForeground }

fun SelectGraphicRenditionSequence.green(): SelectGraphicRenditionSequence =
    apply { foregroundColor = GreenForeground }

fun SelectGraphicRenditionSequence.yellow(): SelectGraphicRenditionSequence =
    apply { foregroundColor = YellowForeground }

fun SelectGraphicRenditionSequence.blue(): SelectGraphicRenditionSequence =
    apply { foregroundColor = BlueForeground }

fun SelectGraphicRenditionSequence.magenta(): SelectGraphicRenditionSequence =
    apply { foregroundColor = MagentaForeground }

fun SelectGraphicRenditionSequence.cyan(): SelectGraphicRenditionSequence =
    apply { foregroundColor = CyanForeground }

fun SelectGraphicRenditionSequence.white(): SelectGraphicRenditionSequence =
    apply { foregroundColor = WhiteForeground }

fun SelectGraphicRenditionSequence.colorPalette(color: UByte): SelectGraphicRenditionSequence =
    apply { foregroundColor = SelectForegroundColor(IndexedColor(color)) }

fun SelectGraphicRenditionSequence.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRenditionSequence =
    apply { foregroundColor = SelectForegroundColor(Rgb(red, green, blue)) }

fun SelectGraphicRenditionSequence.defaultColor(): SelectGraphicRenditionSequence =
    apply { foregroundColor = DefaultForegroundColor }

fun SelectGraphicRenditionSequence.blinking(): SelectGraphicRenditionSequence =
    apply { blink = SlowlyBlinking }

fun SelectGraphicRenditionSequence.rapidBlinking(): SelectGraphicRenditionSequence =
    apply { blink = RapidlyBlinking }

fun SelectGraphicRenditionSequence.notBlinking(): SelectGraphicRenditionSequence =
    apply { blink = NotBlinking }

fun SelectGraphicRenditionSequence.concealed() = apply { conceal = Concealed }

fun SelectGraphicRenditionSequence.revealed() = apply { conceal = Revealed }

fun SelectGraphicRenditionSequence.underlined() = apply { underline = Underlined }

fun SelectGraphicRenditionSequence.notUnderlined() = apply { underline = NotUnderlined }

fun SelectGraphicRenditionSequence.underlineColor(color: UByte) = apply {
    underlineColor = SelectUnderlineColor(
        IndexedColor(color)
    )
}

fun SelectGraphicRenditionSequence.defaultUnderlineColor() = apply { underlineColor = DefaultUnderlineColor }

fun SelectGraphicRenditionSequence.framed() = apply { emojiVariation = Framed }

fun SelectGraphicRenditionSequence.encircled() = apply { emojiVariation = Encircled }

fun SelectGraphicRenditionSequence.resetEmojiVariation() =
    apply { emojiVariation = ResetEmojiVariation }

fun SelectGraphicRenditionSequence.overlined() = apply { overline = Overlined }

fun SelectGraphicRenditionSequence.notOverlined() = apply { overline = NotOverlined }

fun SelectGraphicRenditionSequence.rightSideLine() = apply { ideogram = IdeogramUnderlineOrRightSideLine }

fun SelectGraphicRenditionSequence.doubleRightSideLine() =
    apply { ideogram = IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide }

fun SelectGraphicRenditionSequence.leftSideLine() = apply { ideogram = IdeogramOverlineOrLeftSideLine }

fun SelectGraphicRenditionSequence.doubleLeftSideLine() =
    apply { ideogram = IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide }

fun SelectGraphicRenditionSequence.stressMarking() = apply { ideogram = IdeogramStressMarking }

fun SelectGraphicRenditionSequence.noIdeogram() = apply { ideogram = NoIdeogramAttribute }

fun SelectGraphicRenditionSequence.superscript() = apply { script = Superscript }

fun SelectGraphicRenditionSequence.subscript() = apply { script = Subscript }

fun SelectGraphicRenditionSequence.noscript() = apply { script = NoScriptAttribute }

operator fun SelectGraphicRenditionSequence.plus(intensity: Intensity) = apply { this.intensity = intensity }

operator fun SelectGraphicRenditionSequence.plus(font: Font) = apply { this.font = font }

operator fun SelectGraphicRenditionSequence.plus(underline: Underline) = apply { this.underline = underline }

operator fun SelectGraphicRenditionSequence.plus(blink: Blink) = apply { this.blink = blink }

operator fun SelectGraphicRenditionSequence.plus(reverse: Reverse) = apply { this.reverse = reverse }

operator fun SelectGraphicRenditionSequence.plus(conceal: Conceal) = apply { this.conceal = conceal }

operator fun SelectGraphicRenditionSequence.plus(crossedOut: CrossOut) = apply { this.crossedOut = crossedOut }

operator fun SelectGraphicRenditionSequence.plus(foregroundColor: ForegroundColor) =
    apply { this.foregroundColor = foregroundColor }

operator fun SelectGraphicRenditionSequence.plus(backgroundColor: BackgroundColor?) = apply { this.backgroundColor = backgroundColor }

operator fun SelectGraphicRenditionParameter.plus(other: SelectGraphicRenditionParameter) =
    other.asSequence().basedOn(asSequence())

operator fun SelectGraphicRenditionSequence.plus(parameter: SelectGraphicRenditionParameter) =
    parameter.asSequence().basedOn(this)

fun String.startWithReset(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(startWithReset = ResetOrNormal)

fun String.black(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = BlackForeground)

fun String.red(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = RedForeground)

fun String.green(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = GreenForeground)

fun String.yellow(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = YellowForeground)

fun String.blue(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = BlueForeground)

fun String.magenta(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = MagentaForeground)

fun String.cyan(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = CyanForeground)

fun String.white(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = WhiteForeground)

fun String.colorPalette(color: UByte): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = SelectForegroundColor(IndexedColor(color)))

fun String.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = SelectForegroundColor(Rgb(red, green, blue)))

fun String.defaultColor(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = DefaultForegroundColor)

fun String.blinking(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(blink = SlowlyBlinking)

fun String.rapidBlinking(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(blink = RapidlyBlinking)

fun String.notBlinking(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(blink = NotBlinking)

fun String.concealed() = SelectGraphicRenditionSequence(conceal = Concealed)

fun String.revealed() = SelectGraphicRenditionSequence(conceal = Revealed)

fun String.underlined() = SelectGraphicRenditionSequence(underline = Underlined)

fun String.notUnderlined() = SelectGraphicRenditionSequence(underline = NotUnderlined)

fun String.underlineColor(color: UByte) = SelectGraphicRenditionSequence(
    underlineColor = SelectUnderlineColor(
        IndexedColor(color)
    )
)

fun String.defaultUnderlineColor() = SelectGraphicRenditionSequence(underlineColor = DefaultUnderlineColor)

fun String.framed() = SelectGraphicRenditionSequence(emojiVariation = Framed)

fun String.encircled() = SelectGraphicRenditionSequence(emojiVariation = Encircled)

fun String.resetEmojiVariation() =
    SelectGraphicRenditionSequence(emojiVariation = ResetEmojiVariation)

fun String.overlined() = SelectGraphicRenditionSequence(overline = Overlined)

fun String.notOverlined() = SelectGraphicRenditionSequence(overline = NotOverlined)

fun String.rightSideLine() = SelectGraphicRenditionSequence(ideogram = IdeogramUnderlineOrRightSideLine)

fun String.doubleRightSideLine() =
    SelectGraphicRenditionSequence(ideogram = IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide)

fun String.leftSideLine() = SelectGraphicRenditionSequence(ideogram = IdeogramOverlineOrLeftSideLine)

fun String.doubleLeftSideLine() =
    SelectGraphicRenditionSequence(ideogram = IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide)

fun String.stressMarking() = SelectGraphicRenditionSequence(ideogram = IdeogramStressMarking)

fun String.noIdeogram() = SelectGraphicRenditionSequence(ideogram = NoIdeogramAttribute)

fun String.superscript() = SelectGraphicRenditionSequence(script = Superscript)

fun String.subscript() = SelectGraphicRenditionSequence(script = Subscript)

fun String.noscript() = SelectGraphicRenditionSequence(script = NoScriptAttribute)

operator fun String.plus(intensity: Intensity) = SelectGraphicRenditionSequence(intensity = intensity)

operator fun String.plus(font: Font) = SelectGraphicRenditionSequence(font = font)

operator fun String.plus(underline: Underline) = SelectGraphicRenditionSequence(underline = underline)

operator fun String.plus(blink: Blink) = SelectGraphicRenditionSequence(blink = blink)

operator fun String.plus(reverse: Reverse) = SelectGraphicRenditionSequence(reverse = reverse)

operator fun String.plus(conceal: Conceal) = SelectGraphicRenditionSequence(conceal = conceal)

operator fun String.plus(crossedOut: CrossOut) = SelectGraphicRenditionSequence(crossedOut = crossedOut)

operator fun String.plus(foregroundColor: ForegroundColor) =
    SelectGraphicRenditionSequence(foregroundColor = foregroundColor)

operator fun String.plus(backgroundColor: BackgroundColor?) = SelectGraphicRenditionSequence(backgroundColor = backgroundColor)

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

