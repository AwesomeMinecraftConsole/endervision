package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

fun SelectGraphicRendition.startWithReset(): SelectGraphicRendition =
    apply { startWithReset = ResetOrNormal }

fun SelectGraphicRendition.black(): SelectGraphicRendition =
    apply { foregroundColor = BlackForeground }

fun SelectGraphicRendition.red(): SelectGraphicRendition =
    apply { foregroundColor = RedForeground }

fun SelectGraphicRendition.green(): SelectGraphicRendition =
    apply { foregroundColor = GreenForeground }

fun SelectGraphicRendition.yellow(): SelectGraphicRendition =
    apply { foregroundColor = YellowForeground }

fun SelectGraphicRendition.blue(): SelectGraphicRendition =
    apply { foregroundColor = BlueForeground }

fun SelectGraphicRendition.magenta(): SelectGraphicRendition =
    apply { foregroundColor = MagentaForeground }

fun SelectGraphicRendition.cyan(): SelectGraphicRendition =
    apply { foregroundColor = CyanForeground }

fun SelectGraphicRendition.white(): SelectGraphicRendition =
    apply { foregroundColor = WhiteForeground }

fun SelectGraphicRendition.colorPalette(color: UByte): SelectGraphicRendition =
    apply { foregroundColor = SelectForegroundColor(IndexedColor(color)) }

fun SelectGraphicRendition.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRendition =
    apply { foregroundColor = SelectForegroundColor(Rgb(red, green, blue)) }

fun SelectGraphicRendition.defaultColor(): SelectGraphicRendition =
    apply { foregroundColor = DefaultForegroundColor }

fun SelectGraphicRendition.blinking(): SelectGraphicRendition =
    apply { blink = SlowlyBlinking }

fun SelectGraphicRendition.rapidBlinking(): SelectGraphicRendition =
    apply { blink = RapidlyBlinking }

fun SelectGraphicRendition.notBlinking(): SelectGraphicRendition =
    apply { blink = NotBlinking }

fun SelectGraphicRendition.concealed() = apply { conceal = Concealed }

fun SelectGraphicRendition.revealed() = apply { conceal = Revealed }

fun SelectGraphicRendition.underlined() = apply { underline = Underlined }

fun SelectGraphicRendition.notUnderlined() = apply { underline = NotUnderlined }

fun SelectGraphicRendition.underlineColor(color: UByte) = apply {
    underlineColor = SelectUnderlineColor(
        IndexedColor(color)
    )
}

fun SelectGraphicRendition.defaultUnderlineColor() = apply { underlineColor = DefaultUnderlineColor }

fun SelectGraphicRendition.framed() = apply { emojiVariation = Framed }

fun SelectGraphicRendition.encircled() = apply { emojiVariation = Encircled }

fun SelectGraphicRendition.resetEmojiVariation() =
    apply { emojiVariation = ResetEmojiVariation }

fun SelectGraphicRendition.overlined() = apply { overline = Overlined }

fun SelectGraphicRendition.notOverlined() = apply { overline = NotOverlined }

fun SelectGraphicRendition.rightSideLine() = apply { ideogram = IdeogramUnderlineOrRightSideLine }

fun SelectGraphicRendition.doubleRightSideLine() =
    apply { ideogram = IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide }

fun SelectGraphicRendition.leftSideLine() = apply { ideogram = IdeogramOverlineOrLeftSideLine }

fun SelectGraphicRendition.doubleLeftSideLine() =
    apply { ideogram = IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide }

fun SelectGraphicRendition.stressMarking() = apply { ideogram = IdeogramStressMarking }

fun SelectGraphicRendition.noIdeogram() = apply { ideogram = NoIdeogramAttribute }

fun SelectGraphicRendition.superscript() = apply { script = Superscript }

fun SelectGraphicRendition.subscript() = apply { script = Subscript }

fun SelectGraphicRendition.noscript() = apply { script = NoScriptAttribute }

operator fun SelectGraphicRendition.plus(intensity: Intensity) = apply { this.intensity = intensity }

operator fun SelectGraphicRendition.plus(font: Font) = apply { this.font = font }

operator fun SelectGraphicRendition.plus(underline: Underline) = apply { this.underline = underline }

operator fun SelectGraphicRendition.plus(blink: Blink) = apply { this.blink = blink }

operator fun SelectGraphicRendition.plus(reverse: Reverse) = apply { this.reverse = reverse }

operator fun SelectGraphicRendition.plus(conceal: Conceal) = apply { this.conceal = conceal }

operator fun SelectGraphicRendition.plus(crossedOut: CrossOut) = apply { this.crossedOut = crossedOut }

operator fun SelectGraphicRendition.plus(foregroundColor: ForegroundColor) =
    apply { this.foregroundColor = foregroundColor }

operator fun SelectGraphicRendition.plus(backgroundColor: BackgroundColor?) =
    apply { this.backgroundColor = backgroundColor }

operator fun SelectGraphicRenditionParameter.plus(other: SelectGraphicRenditionParameter) =
    other.asSequence().basedOn(asSequence())

operator fun SelectGraphicRendition.plus(parameter: SelectGraphicRenditionParameter) =
    parameter.asSequence().basedOn(this)

fun String.startWithReset(): SelectGraphicRendition =
    SelectGraphicRendition(startWithReset = ResetOrNormal)

fun String.black(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = BlackForeground)

fun String.red(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = RedForeground)

fun String.green(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = GreenForeground)

fun String.yellow(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = YellowForeground)

fun String.blue(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = BlueForeground)

fun String.magenta(): SelectGraphicRendition =
    SelectGraphicRendition(foregroundColor = MagentaForeground)

fun String.cyan(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = CyanForeground)

fun String.white(): SelectGraphicRendition = SelectGraphicRendition(foregroundColor = WhiteForeground)

fun String.colorPalette(color: UByte): SelectGraphicRendition = SelectGraphicRendition(
    foregroundColor = SelectForegroundColor(
        IndexedColor(color)
    )
)

fun String.rgb(
    red: UByte,
    green: UByte,
    blue: UByte
): SelectGraphicRendition =
    SelectGraphicRendition(foregroundColor = SelectForegroundColor(Rgb(red, green, blue)))

fun String.defaultColor(): SelectGraphicRendition =
    SelectGraphicRendition(foregroundColor = DefaultForegroundColor)

fun String.blinking(): SelectGraphicRendition = SelectGraphicRendition(blink = SlowlyBlinking)

fun String.rapidBlinking(): SelectGraphicRendition = SelectGraphicRendition(blink = RapidlyBlinking)

fun String.notBlinking(): SelectGraphicRendition = SelectGraphicRendition(blink = NotBlinking)

fun String.concealed() = SelectGraphicRendition(conceal = Concealed)

fun String.revealed() = SelectGraphicRendition(conceal = Revealed)

fun String.underlined() = SelectGraphicRendition(underline = Underlined)

fun String.notUnderlined() = SelectGraphicRendition(underline = NotUnderlined)

fun String.underlineColor(color: UByte) = SelectGraphicRendition(
    underlineColor = SelectUnderlineColor(
        IndexedColor(color)
    )
)

fun String.defaultUnderlineColor() = SelectGraphicRendition(underlineColor = DefaultUnderlineColor)

fun String.framed() = SelectGraphicRendition(emojiVariation = Framed)

fun String.encircled() = SelectGraphicRendition(emojiVariation = Encircled)

fun String.resetEmojiVariation() =
    SelectGraphicRendition(emojiVariation = ResetEmojiVariation)

fun String.overlined() = SelectGraphicRendition(overline = Overlined)

fun String.notOverlined() = SelectGraphicRendition(overline = NotOverlined)

fun String.rightSideLine() = SelectGraphicRendition(ideogram = IdeogramUnderlineOrRightSideLine)

fun String.doubleRightSideLine() =
    SelectGraphicRendition(ideogram = IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide)

fun String.leftSideLine() = SelectGraphicRendition(ideogram = IdeogramOverlineOrLeftSideLine)

fun String.doubleLeftSideLine() =
    SelectGraphicRendition(ideogram = IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide)

fun String.stressMarking() = SelectGraphicRendition(ideogram = IdeogramStressMarking)

fun String.noIdeogram() = SelectGraphicRendition(ideogram = NoIdeogramAttribute)

fun String.superscript() = SelectGraphicRendition(script = Superscript)

fun String.subscript() = SelectGraphicRendition(script = Subscript)

fun String.noscript() = SelectGraphicRendition(script = NoScriptAttribute)

operator fun String.plus(intensity: Intensity) = SelectGraphicRendition(intensity = intensity)

operator fun String.plus(font: Font) = SelectGraphicRendition(font = font)

operator fun String.plus(underline: Underline) = SelectGraphicRendition(underline = underline)

operator fun String.plus(blink: Blink) = SelectGraphicRendition(blink = blink)

operator fun String.plus(reverse: Reverse) = SelectGraphicRendition(reverse = reverse)

operator fun String.plus(conceal: Conceal) = SelectGraphicRendition(conceal = conceal)

operator fun String.plus(crossedOut: CrossOut) = SelectGraphicRendition(crossedOut = crossedOut)

operator fun String.plus(foregroundColor: ForegroundColor) =
    SelectGraphicRendition(foregroundColor = foregroundColor)

operator fun String.plus(backgroundColor: BackgroundColor?) =
    SelectGraphicRendition(backgroundColor = backgroundColor)