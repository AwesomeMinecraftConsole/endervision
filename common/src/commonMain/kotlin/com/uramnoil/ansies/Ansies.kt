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
    font: Font? = null,
    blink: Blink? = null,
    conceal: Conceal? = null,
    crossedOut: Strikethrough? = null,
    foregroundColor: ForegroundColor? = null,
    backgroundColor: BackgroundColor? = null,
    underline: Underline? = null,
    underlineColor: UnderLineColor? = null,
    reverse: Reverse? = null,
    emojiVariation: EmojiVariationSelector? = null,
    overline: Overline? = null,
    ideogram: Ideogram? = null,
    script: Script? = null,
    brightForegroundColor: BrightForegroundColor? = null,
    brightBackgroundColor: BrightBackgroundColor? = null,
) {
    var startWithReset = startWithReset
        internal set
    var intensity = intensity
        internal set
    var font = font
        internal set
    var blink = blink
        internal set
    var conceal = conceal
        internal set
    var crossedOut = crossedOut
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

    fun build(): String = Escape(
        ControlSequenceIntroducer(
            SelectGraphicRendition(
                mutableSetOf(
                    startWithReset,
                    intensity,
                    blink,
                    reverse,
                    conceal,
                    crossedOut,
                    foregroundColor,
                    backgroundColor,
                    underline,
                    underlineColor,
                    emojiVariation,
                    overline,
                    ideogram,
                    script,
                    brightForegroundColor,
                    brightBackgroundColor,
                ).filterNotNull().toSet()
            )
        )
    ).build()
}

fun SelectGraphicRenditionSequence.base(base: SelectGraphicRenditionSequence) = apply {
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
    apply { foregroundColor = SetForegroundColorBlack }

fun SelectGraphicRenditionSequence.red(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorRed }

fun SelectGraphicRenditionSequence.green(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorGreen }

fun SelectGraphicRenditionSequence.yellow(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorYellow }

fun SelectGraphicRenditionSequence.blue(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorBlue }

fun SelectGraphicRenditionSequence.magenta(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorMagenta }

fun SelectGraphicRenditionSequence.cyan(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorCyan }

fun SelectGraphicRenditionSequence.white(): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorWhite }

fun SelectGraphicRenditionSequence.colorPalette(color: UByte): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorWith(ColorPaletteParameter(color)) }

fun SelectGraphicRenditionSequence.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRenditionSequence =
    apply { foregroundColor = SetForegroundColorWith(RgbParameter(red, green, blue)) }

fun SelectGraphicRenditionSequence.defaultColor(): SelectGraphicRenditionSequence =
    apply { foregroundColor = DefaultForegroundColor }

fun SelectGraphicRenditionSequence.blinking(): SelectGraphicRenditionSequence =
    apply { blink = SlowBlink }

fun SelectGraphicRenditionSequence.rapidBlinking(): SelectGraphicRenditionSequence =
    apply { blink = RapidBlink }

fun SelectGraphicRenditionSequence.notBlinking(): SelectGraphicRenditionSequence =
    apply { blink = NotBlinking }

fun SelectGraphicRenditionSequence.concealed() = apply { conceal = Concealed }

fun SelectGraphicRenditionSequence.revealed() = apply { conceal = Reveal }

fun SelectGraphicRenditionSequence.underlined() = apply { underline = Underlined }

fun SelectGraphicRenditionSequence.notUnderlined() = apply { underline = NotUnderlined }

fun SelectGraphicRenditionSequence.underlineColor(color: UByte) = apply {
    underlineColor = SetUnderlineColor(
        ColorPaletteParameter(color)
    )
}

fun SelectGraphicRenditionSequence.defaultUnderlineColor() = apply { underlineColor = DefaultUnderlineColor }

fun SelectGraphicRenditionSequence.framed() = apply { emojiVariation = Framed }

fun SelectGraphicRenditionSequence.encircled() = apply { emojiVariation = Encircled }

fun SelectGraphicRenditionSequence.resetEmojiVariation() =
    apply { emojiVariation = NeitherFramedNorEncircled }

fun SelectGraphicRenditionSequence.overlined() = apply { overline = Overlined }

fun SelectGraphicRenditionSequence.notOverlined() = apply { overline = NotOverlined }

fun SelectGraphicRenditionSequence.rightSideLine() = apply { ideogram = IdeogramUnderlineOrRightSideLine }

fun SelectGraphicRenditionSequence.doubleRightSideLine() =
    apply { ideogram = IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide }

fun SelectGraphicRenditionSequence.leftSideLine() = apply { ideogram = IdeogramOverlineOrLeftSideLine }

fun SelectGraphicRenditionSequence.doubleLeftSideLine() =
    apply { ideogram = IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide }

fun SelectGraphicRenditionSequence.stressMarking() = apply { ideogram = IdeogramStressMarking }

fun SelectGraphicRenditionSequence.noIdeogram() = apply { ideogram = NoIdeogramSelectAttributes }

fun SelectGraphicRenditionSequence.superscript() = apply { script = Superscript }

fun SelectGraphicRenditionSequence.subscript() = apply { script = Subscript }

fun SelectGraphicRenditionSequence.noscript() = apply { script = NeitherSuperscriptNorSubscript }

operator fun SelectGraphicRenditionSequence.plus(intensity: Intensity) = apply { this.intensity = intensity }

operator fun SelectGraphicRenditionSequence.plus(font: Font) = apply { this.font = font }

operator fun SelectGraphicRenditionSequence.plus(underline: Underline) = apply { this.underline = underline }

operator fun SelectGraphicRenditionSequence.plus(blink: Blink) = apply { this.blink = blink }

operator fun SelectGraphicRenditionSequence.plus(reverse: Reverse) = apply { this.reverse = reverse }

operator fun SelectGraphicRenditionSequence.plus(conceal: Conceal) = apply { this.conceal = conceal }

operator fun SelectGraphicRenditionSequence.plus(crossedOut: Strikethrough) = apply { this.crossedOut = crossedOut }

operator fun SelectGraphicRenditionSequence.plus(foregroundColor: ForegroundColor) =
    apply { this.foregroundColor = foregroundColor }

operator fun SelectGraphicRenditionSequence.plus(backgroundColor: BackgroundColor?) = apply { this.backgroundColor = backgroundColor }

operator fun SelectGraphicRenditionParameter.plus(other: SelectGraphicRenditionParameter) =
    other.asSequence().base(asSequence())

operator fun SelectGraphicRenditionSequence.plus(parameter: SelectGraphicRenditionParameter) =
    parameter.asSequence().base(this)

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

