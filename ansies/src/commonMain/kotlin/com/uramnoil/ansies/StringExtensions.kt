package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*

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