package com.uramnoil.ansies.parameter

import com.uramnoil.ansies.plus

enum class ControlSequenceIntroducerParameters(val abbr: String, val suffix: Char) {
    CursorUp("CUU", 'A') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorDown("CUD", 'B') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorForward("CUF", 'C') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorBack("CSB", 'E') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorNextLine("CNL", 'F') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorPreviousLine("CPL", 'G') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    CursorPosition("CUP", 'H') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    EraseDisplay("ED", 'J') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    EraseInLine("EL", 'K') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    ScrollUp("SU", 'S') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    ScrollDown("SD", 'T') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    HorizontalVerticalPosition("HVP", 'f') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    SelectGraphicRendition("SGR", 'm') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            return SelectGraphicRendition(SelectGraphicRenditionParameter.parse(argument))
        }
    },
    AuxPortOn("", 'i') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    AuxPortOff("", 'i') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    },
    DeviceStatusReport("DSR", 'n') {
        override fun parse(argument: String): ControlSequenceIntroducerParameter {
            TODO("Not yet implemented")
        }
    }, ;

    override fun toString(): String = suffix.toString()
    abstract fun parse(argument: String): ControlSequenceIntroducerParameter
}

class ControlSequenceIntroducer(val parameter: ControlSequenceIntroducerParameter) : EscapeParameter() {
    override val type: EscapeParameters = EscapeParameters.ControlSequenceIntroducer
    override fun build(): String = type.build() + parameter.build()
}

sealed class ControlSequenceIntroducerParameter {
    companion object {
        val map = ControlSequenceIntroducerParameters.values().associateBy { it.suffix }

        fun parse(string: String): ControlSequenceIntroducerParameter {
            val argument = string.dropLast(1)
            val type = string.last()
            return map[type]?.parse(argument) ?: throw IllegalArgumentException("doesn't match eny CSI suffix.")
        }
    }

    abstract val type: ControlSequenceIntroducerParameters
    abstract fun build(): String
}

fun ControlSequenceIntroducerParameter.withoutArg() = "$type"

fun ControlSequenceIntroducerParameter.withArgN(n: Int) = "$n$type"

fun ControlSequenceIntroducerParameter.withArgNM(n: Int, m: Int) = "$n:$m$type"

class CursorUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorUp
    override fun build(): String = withArgN(n)
}

class CursorDown(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorDown
    override fun build(): String = withArgN(n)
}

class CursorForward(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorForward
    override fun build(): String = withArgN(n)
}

class CursorCursorBack(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorBack
    override fun build(): String = withArgN(n)
}

class CursorNextLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorNextLine
    override fun build(): String = withArgN(n)
}

class CursorPreviousLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters =
        ControlSequenceIntroducerParameters.CursorPreviousLine

    override fun build(): String = withArgN(n)
}

class CursorPosition(val n: Int = 1, val m: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.CursorPosition
    override fun build(): String = withArgN(n)
}

class EraseDisplay(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.EraseDisplay
    override fun build(): String = withArgN(n)
}

class EraseInLine(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.EraseInLine
    override fun build(): String = withArgN(n)
}

class ScrollUp(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.ScrollUp
    override fun build(): String = withArgN(n)
}

class ScrollDown(val n: Int = 1, val m: Int) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.ScrollDown
    override fun build(): String = withArgNM(n, m)
}

class HorizontalVerticalPosition(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters =
        ControlSequenceIntroducerParameters.HorizontalVerticalPosition

    override fun build(): String = withArgN(n)
}

data class SelectGraphicRendition(
    var startWithReset: ResetOrNormal? = null,
    var intensity: Intensity? = null,
    var penmanship: Penmanship? = null,
    var font: Font? = null,
    var blink: Blink? = null,
    var conceal: Conceal? = null,
    var crossedOut: CrossOut? = null,
    var foregroundColor: ForegroundColor? = null,
    var backgroundColor: BackgroundColor? = null,
    var underline: Underline? = null,
    var reverse: Reverse? = null,
    var emojiVariation: EmojiVariation? = null,
    var overline: Overline? = null,
    var underlineColor: UnderLineColor? = null,
    var ideogram: Ideogram? = null,
    var script: Script? = null,
    var brightForegroundColor: BrightForegroundColor? = null,
    var brightBackgroundColor: BrightBackgroundColor? = null,
) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters =
        ControlSequenceIntroducerParameters.SelectGraphicRendition

    /**
     * Construct a SelectGraphicRenditionSequence and change it to a String.
     * The order of the sequence is roughly based on the ascending order of each parameter's number.
     *
     * 1. Reset (0)
     * 1. Intensity
     *      - BoldOrIncreasedIntensity (1)
     *      - Faint, decreased intensity or second colour (2)
     *      ???NormalIntensity (22)
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

fun SelectGraphicRendition(parameters: Set<SelectGraphicRenditionParameter>): SelectGraphicRendition {
    return parameters.fold(SelectGraphicRendition()) { acc, selectGraphicRenditionParameter ->
        acc + selectGraphicRenditionParameter
    }
}

fun SelectGraphicRendition.overridedBy(base: SelectGraphicRendition): SelectGraphicRendition {
    if (base.startWithReset != null) {
        return base
    }

    return apply {
        if (base.intensity != null) {
            intensity = base.intensity
        }
        if (base.blink != null) {
            blink = base.blink
        }
        if (base.reverse != null) {
            reverse = base.reverse
        }
        if (base.conceal != null) {
            conceal = base.conceal
        }
        if (base.crossedOut != null) {
            crossedOut = base.crossedOut
        }
        if (base.foregroundColor != null) {
            foregroundColor = base.foregroundColor
        }
        if (base.backgroundColor != null) {
            backgroundColor = base.backgroundColor
        }
        if (base.underline != null) {
            underline = base.underline
        }
        if (base.underlineColor != null) {
            underlineColor = base.underlineColor
        }
        if (base.emojiVariation != null) {
            emojiVariation = base.emojiVariation
        }
        if (base.overline != null) {
            overline = base.overline
        }
        if (base.ideogram != null) {
            ideogram = base.ideogram
        }
        if (base.script != null) {
            script = base.script
        }
        if (base.brightForegroundColor != null) {
            brightForegroundColor = base.brightForegroundColor
        }
        if (base.brightBackgroundColor != null) {
            brightBackgroundColor = base.brightBackgroundColor
        }
    }.copy()
}

class AuxPortOn(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.AuxPortOn
    override fun build(): String = withoutArg()
}

class AuxPortOff(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters = ControlSequenceIntroducerParameters.AuxPortOff
    override fun build(): String = withoutArg()
}

class DeviceStatusReport(val n: Int = 1) : ControlSequenceIntroducerParameter() {
    override val type: ControlSequenceIntroducerParameters =
        ControlSequenceIntroducerParameters.DeviceStatusReport

    override fun build(): String = withoutArg()
}