package com.uramnoil.ansies.parameter

enum class ControlSequenceIntroducerType(val abbr: String, val suffix: String) {
    CursorUp("CUU", "A"),
    CursorDown("CUD", "B"),
    CursorForward("CUF", "C"),
    CursorBack("CSB", "E"),
    CursorNextLine("CNL", "F"),
    CursorPreviousLine("CPL", "G"),
    CursorPosition("CUP", "H"),
    EraseDisplay("ED", "J"),
    EraseInLine("EL", "K"),
    ScrollUp("SU", "S"),
    ScrollDown("SD", "T"),
    HorizontalVerticalPosition("HVP", "f"),
    SelectGraphicRendition("SGR", "m"),
    AuxPortOn("", "5i"),
    AuxPortOff("", "4i"),
    DeviceStatusReport("DSR", "6n"), ;

    override fun toString(): String = suffix
}

class ControlSequenceIntroducer(val parameter: ControlSequenceIntroducerParameter) : EscapeSequenceParameter() {
    override val type: EscapeSequenceParameterType = EscapeSequenceParameterType.ControlSequenceIntroducer
    override fun build(): String = type.build() + parameter.build()
}

sealed class ControlSequenceIntroducerParameter {
    abstract val type: ControlSequenceIntroducerType
    abstract fun build(): String
}

fun ControlSequenceIntroducerParameter.withoutArg() = "$type"

fun ControlSequenceIntroducerParameter.withArgN(n: Int) = "$n$type"

fun ControlSequenceIntroducerParameter.withArgNM(n: Int, m: Int) = "$n:$m$type"

class CursorUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorUp
    override fun build(): String = withArgN(n)
}

class CursorDown(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorDown
    override fun build(): String = withArgN(n)
}

class CursorForward(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorForward
    override fun build(): String = withArgN(n)
}

class CursorCursorBack(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorBack
    override fun build(): String = withArgN(n)
}

class CursorNextLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorNextLine
    override fun build(): String = withArgN(n)
}

class CursorPreviousLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorPreviousLine
    override fun build(): String = withArgN(n)
}

class CursorPosition(val n: Int = 1, val m: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.CursorPosition
    override fun build(): String = withArgN(n)
}

class EraseDisplay(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.EraseDisplay
    override fun build(): String = withArgN(n)
}

class EraseInLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.EraseInLine
    override fun build(): String = withArgN(n)
}

class ScrollUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.ScrollUp
    override fun build(): String = withArgN(n)
}

class ScrollDown(val n: Int = 1, val m: Int) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.ScrollDown
    override fun build(): String = withArgNM(n, m)
}

class HorizontalVerticalPosition(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.HorizontalVerticalPosition
    override fun build(): String = withArgN(n)
}

class SelectGraphicRendition(
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
) : ControlSequenceIntroducerParameter() {
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

    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.SelectGraphicRendition

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
    override fun build(): String = mutableSetOf(
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
    )
        .filterNotNull()
        .map { it.build() }
        .joinToString(";") + "$type"
}

fun SelectGraphicRendition.basedOn(base: SelectGraphicRendition) = apply {
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

class AuxPortOn(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.AuxPortOn
    override fun build(): String = withoutArg()
}

class AuxPortOff(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.AuxPortOff
    override fun build(): String = withoutArg()
}

class DeviceStatusReport(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerType = ControlSequenceIntroducerType.DeviceStatusReport
    override fun build(): String = withoutArg()
}