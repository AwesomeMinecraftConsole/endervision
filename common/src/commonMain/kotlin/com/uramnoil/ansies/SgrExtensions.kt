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

fun ansiOf(parameter: SelectGraphicRenditionParameter) =
    AsciiCodeOrStringSequence(listOf(AsciiCodeOrString.AsciiCode(Escape(ControlSequenceIntroducer(parameter.asSequence())))))

fun ansiOf(sgr: SelectGraphicRendition) =
    AsciiCodeOrStringSequence(listOf(AsciiCodeOrString.AsciiCode(Escape(ControlSequenceIntroducer(sgr)))))

operator fun SelectGraphicRendition.plus(string: String): AsciiCodeOrStringSequence {
    return AsciiCodeOrStringSequence(
        listOf(
            AsciiCodeOrString.AsciiCode(
                Escape(
                    ControlSequenceIntroducer(this)
                )
            ),
            AsciiCodeOrString.String(string)
        )
    )
}

operator fun SelectGraphicRendition.plus(sgr: SelectGraphicRendition): AsciiCodeOrStringSequence {
    return AsciiCodeOrStringSequence(
        listOf(
            AsciiCodeOrString.AsciiCode(Escape(ControlSequenceIntroducer(this))),
            AsciiCodeOrString.AsciiCode(Escape(ControlSequenceIntroducer(sgr)))
        )
    )
}