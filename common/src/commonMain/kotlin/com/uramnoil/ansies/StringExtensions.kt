package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

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

operator fun SelectGraphicRenditionSequence.plus(backgroundColor: BackgroundColor?) =
    apply { this.backgroundColor = backgroundColor }

operator fun SelectGraphicRenditionParameter.plus(other: SelectGraphicRenditionParameter) =
    other.asSequence().basedOn(asSequence())

operator fun SelectGraphicRenditionSequence.plus(parameter: SelectGraphicRenditionParameter) =
    parameter.asSequence().basedOn(this)

fun String.startWithReset(): SelectGraphicRenditionSequence =
    SelectGraphicRenditionSequence(startWithReset = ResetOrNormal)

fun String.black(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = BlackForeground)

fun String.red(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = RedForeground)

fun String.green(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = GreenForeground)

fun String.yellow(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = YellowForeground)

fun String.blue(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = BlueForeground)

fun String.magenta(): SelectGraphicRenditionSequence =
    SelectGraphicRenditionSequence(foregroundColor = MagentaForeground)

fun String.cyan(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = CyanForeground)

fun String.white(): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(foregroundColor = WhiteForeground)

fun String.colorPalette(color: UByte): SelectGraphicRenditionSequence = SelectGraphicRenditionSequence(
    foregroundColor = SelectForegroundColor(
        IndexedColor(color)
    )
)

fun String.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRenditionSequence =
    SelectGraphicRenditionSequence(foregroundColor = SelectForegroundColor(Rgb(red, green, blue)))

fun String.defaultColor(): SelectGraphicRenditionSequence =
    SelectGraphicRenditionSequence(foregroundColor = DefaultForegroundColor)

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

operator fun String.plus(backgroundColor: BackgroundColor?) =
    SelectGraphicRenditionSequence(backgroundColor = backgroundColor)