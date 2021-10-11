package com.uramnoil.ansies.parameter

enum class SelectGraphicRenditionParameters(val m: Int) {
    ResetOrNormal(0) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.ResetOrNormal to parameters
        }
    },
    BoldOrIncreasedIntensity(1) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BoldOrIncreasedIntensity to parameters
        }
    },
    FaintDecreasedIntensityOrDim(2) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.FaintDecreasedIntensityOrDim to parameters
        }
    },
    Italicized(3) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Italicized to parameters
        }
    },
    Underline(4) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Underlined to parameters
        }
    },
    SlowBlink(5) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.SlowlyBlinking to parameters
        }
    },
    RapidBlink(6) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.RapidlyBlinking to parameters
        }
    },
    Reversed(7) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Reversed to parameters
        }
    },
    ConcealOrHide(8) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Concealed to parameters
        }
    },
    CrossedOut(9) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.CrossedOut to parameters
        }
    },
    PrimaryFont(10) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.PrimaryFont to parameters
        }
    },
    AlternativeFont1(11) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont1 to parameters
        }
    },
    AlternativeFont2(12) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont2 to parameters
        }
    },
    AlternativeFont3(13) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont3 to parameters
        }
    },
    AlternativeFont4(14) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont4 to parameters
        }
    },
    AlternativeFont5(15) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont5 to parameters
        }
    },
    AlternativeFont6(16) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont6 to parameters
        }
    },
    AlternativeFont7(17) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont7 to parameters
        }
    },
    AlternativeFont8(18) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont8 to parameters
        }
    },
    AlternativeFont9(19) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.AlternativeFont9 to parameters
        }
    },
    Fraktur(20) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Fraktur to parameters
        }
    },
    DoublyUnderlinedOrNotBold(21) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.DoublyUnderlined to parameters
        }
    },
    NormalIntensity(22) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NormalIntensity to parameters
        }
    },
    NeitherItalicNorBlackletter(23) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.ResetPenmanship to parameters
        }
    },
    NotUnderlined(24) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NotUnderlined to parameters
        }
    },
    NotBlinking(25) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NotBlinking to parameters
        }
    },
    ProportionalSpacing(26) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.ProportionalSpacing to parameters
        }
    },
    NotReversed(27) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NotReversed to parameters
        }
    },
    Reveal(28) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Revealed to parameters
        }
    },
    NotCrossedOut(29) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NotCrossedOut to parameters
        }
    },
    BlackForeground(30) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BlackForeground to parameters
        }
    },
    RedForeground(31) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.RedForeground to parameters
        }
    },
    GreenForeground(32) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.GreenForeground to parameters
        }
    },
    YellowForeground(33) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.YellowForeground to parameters
        }
    },
    BlueForeground(34) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BlueForeground to parameters
        }
    },
    MagentaForeground(35) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.MagentaForeground to parameters
        }
    },
    CyanForeground(36) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.CyanForeground to parameters
        }
    },
    WhiteForeground(37) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.WhiteForeground to parameters
        }
    },
    ForegroundColor(38) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            val (parameter, left) = ColorParameter.parse(parameters)
            return com.uramnoil.ansies.parameter.SelectForegroundColor(parameter) to left
        }
    },
    DefaultForegroundColor(39) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.DefaultForegroundColor to parameters
        }
    },
    BlackBackground(40) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BlackBackground to parameters
        }
    },
    RedBackground(41) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.RedBackground to parameters
        }
    },
    GreenBackground(42) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.GreenBackground to parameters
        }
    },
    YellowBackground(43) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.YellowBackground to parameters
        }
    },
    BlueBackground(44) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BlueBackground to parameters
        }
    },
    MagentaBackground(45) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.MagentaBackground to parameters
        }
    },
    CyanBackground(46) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.CyanBackground to parameters
        }
    },
    WhiteBackground(47) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.WhiteBackground to parameters
        }
    },
    BackgroundColor(48) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            val (parameter, left) = ColorParameter.parse(parameters)
            return com.uramnoil.ansies.parameter.SelectBackgroundColor(parameter) to left
        }
    },
    DefaultBackgroundColor(49) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.DefaultBackgroundColor to parameters
        }
    },
    DisableProportionalSpacing(50) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            TODO("Not yet implemented")
        }
    },
    Framed(51) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Framed to parameters
        }
    },
    Encircled(52) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Encircled to parameters
        }
    },
    Overlined(53) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Overlined to parameters
        }
    },
    ResetEmojiVariation(54) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.ResetEmojiVariation to parameters
        }
    },
    NotOverlined(55) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NotOverlined to parameters
        }
    },
    SelectUnderlineColor(58) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            val (parameter, left) = ColorParameterMode.IndexedColor.parse(parameters) as Pair<IndexedColor, List<Int>>
            return com.uramnoil.ansies.parameter.SelectUnderlineColor(parameter) to left
        }
    },
    DefaultUnderlineColor(59) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.DefaultUnderlineColor to parameters
        }
    },
    IdeogramUnderlineOrRightSideLine(60) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.IdeogramUnderlineOrRightSideLine to parameters
        }
    },
    IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide(61) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide to parameters
        }
    },
    IdeogramOverlineOrLeftSideLine(62) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.IdeogramOverlineOrLeftSideLine to parameters
        }
    },
    IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide(63) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide to parameters
        }
    },
    IdeogramStressMarking(64) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.IdeogramStressMarking to parameters
        }
    },
    NoIdeogramAttribute(65) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NoIdeogramAttribute to parameters
        }
    },
    Superscript(73) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Superscript to parameters
        }
    },
    Subscript(74) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.Subscript to parameters
        }
    },
    NeitherSuperscriptNorSubscript(75) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.NoScriptAttribute to parameters
        }
    },
    BrightBlackForeground(90) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightBlackForeground to parameters
        }
    },
    BrightRedForeground(91) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightRedForeground to parameters
        }
    },
    BrightGreenForeground(92) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightGreenForeground to parameters
        }
    },
    BrightYellowForeground(93) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightYellowForeground to parameters
        }
    },
    BrightBlueForeground(94) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightBlueForeground to parameters
        }
    },
    BrightMagentaForeground(95) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightMagentaForeground to parameters
        }
    },
    BrightCyanForeground(96) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightCyanForeground to parameters
        }
    },
    BrightWhiteForeground(97) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightWhiteForeground to parameters
        }
    },
    BrightBlackBackground(100) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightBlackBackground to parameters
        }
    },
    BrightRedBackground(101) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightRedBackground to parameters
        }
    },
    BrightGreenBackground(102) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightGreenBackground to parameters
        }
    },
    BrightYellowBackground(103) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightYellowBackground to parameters
        }
    },
    BrightBlueBackground(104) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightBlueBackground to parameters
        }
    },
    BrightMagentaBackground(105) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightMagentaBackground to parameters
        }
    },
    BrightCyanBackground(106) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightCyanBackground to parameters
        }
    },
    BrightWhiteBackground(107) {
        override fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>> {
            return com.uramnoil.ansies.parameter.BrightWhiteBackground to parameters
        }
    }, ;

    override fun toString(): String = m.toString()

    /**
     * @return the second value of the pair explains how many parameters consumed.
     */
    abstract fun parse(parameters: List<Int>): Pair<SelectGraphicRenditionParameter, List<Int>>
}

sealed class SelectGraphicRenditionParameter {
    companion object {
        val map = SelectGraphicRenditionParameters.values().associateBy { it.m }

        fun parse(string: String): Set<SelectGraphicRenditionParameter> {
            val parameters = string.split(';').map { if (it == "") 0 else it.toInt() }
            var left = parameters
            val selectGraphicRenditionParameters = mutableSetOf<SelectGraphicRenditionParameter>()
            while (left.isNotEmpty()) {
                val type = left.first()
                left = left.drop(1)
                val (selectGraphicRenditionParameter, resultLeft) = map[type]?.parse(left)
                    ?: throw IllegalArgumentException("doesn't match eny codes")
                selectGraphicRenditionParameters.add(selectGraphicRenditionParameter)
                left = resultLeft
            }
            return selectGraphicRenditionParameters
        }
    }

    abstract val type: SelectGraphicRenditionParameters
    abstract fun build(): String
    abstract fun asSequence(): SelectGraphicRendition
    var string: String = ""
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

/**
 * 0
 */
object ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameters.ResetOrNormal
    override fun build(): String = withoutArg()
    override fun asSequence() = SelectGraphicRendition(startWithReset = this)
}

sealed class Intensity : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(intensity = this)
}


/**
 * 1
 */
object BoldOrIncreasedIntensity : Intensity() {
    override val type = SelectGraphicRenditionParameters.BoldOrIncreasedIntensity
    override fun build(): String = withoutArg()
}

/**
 * 2
 */
object FaintDecreasedIntensityOrDim : Intensity() {
    override val type = SelectGraphicRenditionParameters.FaintDecreasedIntensityOrDim
    override fun build(): String = withoutArg()
}

sealed class Penmanship : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(penmanship = this)
}

/**
 * 3
 */
object Italicized : Penmanship() {
    override val type = SelectGraphicRenditionParameters.Italicized
    override fun build(): String = withoutArg()
}

typealias Gothic = Italicized

sealed class Underline : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(underline = this)
}

/**
 * 4
 */
object Underlined : Underline() {
    override val type = SelectGraphicRenditionParameters.Underline
    override fun build(): String = withoutArg()
}

sealed class Blink : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(blink = this)
}

/**
 * 5
 */
object SlowlyBlinking : Blink() {
    override val type = SelectGraphicRenditionParameters.SlowBlink
    override fun build(): String = withoutArg()
}

/**
 * 6
 */
object RapidlyBlinking : Blink() {
    override val type = SelectGraphicRenditionParameters.RapidBlink
    override fun build(): String = withoutArg()
}

sealed class Reverse : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(reverse = this)
}

/**
 * 7
 */
object Reversed : Reverse() {
    override val type = SelectGraphicRenditionParameters.Reversed
    override fun build(): String = withoutArg()
}

sealed class Conceal : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(conceal = this)
}

/**
 * 8
 */
object Concealed : Conceal() {
    override val type = SelectGraphicRenditionParameters.ConcealOrHide
    override fun build(): String = withoutArg()
}

sealed class CrossOut : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(crossedOut = this)
}

/**
 * 9
 */
object CrossedOut : CrossOut() {
    override val type = SelectGraphicRenditionParameters.CrossedOut
    override fun build(): String = withoutArg()
}

sealed class Font : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(font = this)
}

/**
 * 10
 */
object PrimaryFont : Font() {
    override val type = SelectGraphicRenditionParameters.PrimaryFont
    override fun build(): String = withoutArg()
}

/**
 * 11
 */
object AlternativeFont1 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont1
    override fun build(): String = withoutArg()
}

/**
 * 12
 */
object AlternativeFont2 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont2
    override fun build(): String = withoutArg()
}

/**
 * 13
 */
object AlternativeFont3 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont3
    override fun build(): String = withoutArg()
}

/**
 * 14
 */
object AlternativeFont4 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont4
    override fun build(): String = withoutArg()
}

/**
 * 15
 */
object AlternativeFont5 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont5
    override fun build(): String = withoutArg()
}

/**
 * 16
 */
object AlternativeFont6 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont6
    override fun build(): String = withoutArg()
}

/**
 * 17
 */
object AlternativeFont7 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont7
    override fun build(): String = withoutArg()
}

/**
 * 18
 */
object AlternativeFont8 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont8
    override fun build(): String = withoutArg()
}

/**
 * 19
 */
object AlternativeFont9 : Font() {
    override val type = SelectGraphicRenditionParameters.AlternativeFont9
    override fun build(): String = withoutArg()
}

/**
 * 20
 */
object Fraktur : Penmanship() {
    override val type = SelectGraphicRenditionParameters.Fraktur
    override fun build(): String = withoutArg()
}

/**
 * 21
 */
object DoublyUnderlined : Underline() {
    override val type = SelectGraphicRenditionParameters.DoublyUnderlinedOrNotBold
    override fun build(): String = withoutArg()
}

/**
 * 22
 */
object NormalIntensity : Intensity() {
    override val type = SelectGraphicRenditionParameters.NormalIntensity
    override fun build(): String = withoutArg()
}

/**
 * 23
 */
object ResetPenmanship : Penmanship() {
    override val type = SelectGraphicRenditionParameters.NeitherItalicNorBlackletter
    override fun build(): String = withoutArg()
}

/**
 * 24
 * Neither singly nor doubly
 */
object NotUnderlined : Underline() {
    override val type = SelectGraphicRenditionParameters.NotUnderlined
    override fun build(): String = withoutArg()
}

/**
 * 25
 * Disable blinking
 */
object NotBlinking : Blink() {
    override val type = SelectGraphicRenditionParameters.NotBlinking
    override fun build(): String = withoutArg()
}

/**
 * 26
 * Reserved for proportional spacing as specified in the CCITT Recommendation.
 * In other words, it's not in use now.
 */
object ProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameters.ProportionalSpacing
    override fun build(): String = withoutArg()
    override fun asSequence(): SelectGraphicRendition {
        TODO("Not yet implemented")
    }
}

/**
 * 27
 */
object NotReversed : Reverse() {
    override val type = SelectGraphicRenditionParameters.NotReversed
    override fun build(): String = withoutArg()
}

/**
 * 28
 */
object Revealed : Conceal() {
    override val type = SelectGraphicRenditionParameters.Reveal
    override fun build(): String = withoutArg()
}

/**
 * 29
 */
object NotCrossedOut : CrossOut() {
    override val type = SelectGraphicRenditionParameters.NotCrossedOut
    override fun build(): String = withoutArg()
}

sealed class ForegroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(foregroundColor = this)
}

/**
 * 30
 */
object BlackForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BlackForeground
    override fun build(): String = withoutArg()
}

/**
 * 31
 */
object RedForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.RedForeground
    override fun build(): String = withoutArg()
}

/**
 * 32
 */
object GreenForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.GreenForeground
    override fun build(): String = withoutArg()
}

/**
 * 33
 */
object YellowForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.YellowForeground
    override fun build(): String = withoutArg()
}

/**
 * 34
 */
object BlueForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BlueForeground
    override fun build(): String = withoutArg()
}

/**
 * 35
 */
object MagentaForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.MagentaForeground
    override fun build(): String = withoutArg()
}

/**
 * 36
 */
object CyanForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.CyanForeground
    override fun build(): String = withoutArg()
}

/**
 * 37
 */
object WhiteForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.WhiteForeground
    override fun build(): String = withoutArg()
}

/**
 * 38
 */
data class SelectForegroundColor(val parameter: ColorParameter) : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.ForegroundColor
    override fun build(): String = "$type;${parameter.build()}"
}

fun SelectForegroundColor(color: UByte) = SelectForegroundColor(IndexedColor(color))

/**
 * The reason for class name with 'Rgb' at the end is there is CYM in addition to RGB,
 * and overloading is impossible.
 */
fun SelectForegroundColorRgb(red: UByte, green: UByte, blue: UByte) =
    SelectForegroundColor(Rgb(red, green, blue))

/**
 * 39
 */
object DefaultForegroundColor : ForegroundColor() {
    override val type = SelectGraphicRenditionParameters.DefaultForegroundColor
    override fun build(): String = withoutArg()
}

sealed class BackgroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(backgroundColor = this)
}

/**
 * 40
 */
object BlackBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BlackBackground
    override fun build(): String = withoutArg()
}

/**
 * 41
 */
object RedBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.RedBackground
    override fun build(): String = withoutArg()
}

/**
 * 42
 */
object GreenBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.GreenBackground
    override fun build(): String = withoutArg()
}

/**
 * 43
 */
object YellowBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.YellowBackground
    override fun build(): String = withoutArg()
}

/**
 * 44
 */
object BlueBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BlueBackground
    override fun build(): String = withoutArg()
}

/**
 * 45
 */
object MagentaBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.MagentaBackground
    override fun build(): String = withoutArg()
}

/**
 * 46
 */
object CyanBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.CyanBackground
    override fun build(): String = withoutArg()
}

/**
 * 47
 */
object WhiteBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.WhiteBackground
    override fun build(): String = withoutArg()
}

/**
 * 48
 */
data class SelectBackgroundColor(val parameter: ColorParameter) : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BackgroundColor
    override fun build(): String = "$type;${parameter.build()}"
}

/**
 * Indexed color
 */
fun SelectBackgroundColor(color: UByte) = SelectBackgroundColor(IndexedColor(color))

/**
 * RGB
 */
fun SelectBackgroundColor(red: UByte, green: UByte, blue: UByte) =
    SelectBackgroundColor(Rgb(red, green, blue))

/**
 * 49
 */
object DefaultBackgroundColor : BackgroundColor() {
    override val type = SelectGraphicRenditionParameters.DefaultBackgroundColor
    override fun build(): String = withoutArg()
}

/**
 * 50
 */
object NotVariableSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameters.DisableProportionalSpacing
    override fun build(): String = withoutArg()
    override fun asSequence(): SelectGraphicRendition {
        TODO("Not yet implemented")
    }
}

sealed class EmojiVariation : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(emojiVariation = this)
}

/**
 * 51
 */
object Framed : EmojiVariation() {
    override val type = SelectGraphicRenditionParameters.Framed
    override fun build(): String = withoutArg()
}

/**
 * 52
 */
object Encircled : EmojiVariation() {
    override val type = SelectGraphicRenditionParameters.Encircled
    override fun build(): String = withoutArg()
}

sealed class Overline : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(overline = this)
}

/**
 * 53
 */
object Overlined : Overline() {
    override val type = SelectGraphicRenditionParameters.Overlined
    override fun build(): String = withoutArg()
}

/**
 * 54
 */
object ResetEmojiVariation : EmojiVariation() {
    override val type = SelectGraphicRenditionParameters.ResetEmojiVariation
    override fun build(): String = withoutArg()
}

/**
 * 55
 */
object NotOverlined : Overline() {
    override val type = SelectGraphicRenditionParameters.NotOverlined
    override fun build(): String = withoutArg()
}

sealed class UnderLineColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(underlineColor = this)
}

/**
 * 58
 */
data class SelectUnderlineColor(val parameter: IndexedColor) : UnderLineColor() {
    override val type = SelectGraphicRenditionParameters.SelectUnderlineColor
    override fun build(): String = type.toString() + parameter.build()
}

/**
 * 59
 */
object DefaultUnderlineColor : UnderLineColor() {
    override val type = SelectGraphicRenditionParameters.DefaultUnderlineColor
    override fun build(): String = withoutArg()
}

sealed class Ideogram : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(ideogram = this)
}

/**
 * 60
 */
object IdeogramUnderlineOrRightSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameters.IdeogramUnderlineOrRightSideLine
    override fun build(): String = withoutArg()
}

/**
 * 61
 */
object IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide : Ideogram() {
    override val type = SelectGraphicRenditionParameters.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide
    override fun build(): String = withoutArg()
}

/**
 * 62
 */
object IdeogramOverlineOrLeftSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameters.IdeogramOverlineOrLeftSideLine
    override fun build(): String = withoutArg()
}

/**
 * 63
 */
object IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide : Ideogram() {
    override val type = SelectGraphicRenditionParameters.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide
    override fun build(): String = withoutArg()
}

/**
 * 64
 */
object IdeogramStressMarking : Ideogram() {
    override val type = SelectGraphicRenditionParameters.IdeogramStressMarking
    override fun build(): String = withoutArg()
}

/**
 * 65
 */
object NoIdeogramAttribute : Ideogram() {
    override val type = SelectGraphicRenditionParameters.NoIdeogramAttribute
    override fun build(): String = withoutArg()
}

sealed class Script : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(script = this)
}

/**
 * 73
 */
object Superscript : Script() {
    override val type = SelectGraphicRenditionParameters.Superscript
    override fun build(): String = withoutArg()
}

/**
 * 74
 */
object Subscript : Script() {
    override val type = SelectGraphicRenditionParameters.Subscript
    override fun build(): String = withoutArg()
}

/**
 * 75
 */
object NoScriptAttribute : Script() {
    override val type = SelectGraphicRenditionParameters.NeitherSuperscriptNorSubscript
    override fun build(): String = withoutArg()
}

sealed class BrightForegroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(brightForegroundColor = this)
}

/**
 * 90
 */
object BrightBlackForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightBlackForeground
    override fun build(): String = withoutArg()
}

/**
 * 91
 */
object BrightRedForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightRedForeground
    override fun build(): String = withoutArg()
}

/**
 * 92
 */
object BrightGreenForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightGreenForeground
    override fun build(): String = withoutArg()
}

/**
 * 93
 */
object BrightYellowForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightYellowForeground
    override fun build(): String = withoutArg()
}

/**
 * 94
 */
object BrightBlueForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightBlueForeground
    override fun build(): String = withoutArg()
}

/**
 * 95
 */
object BrightMagentaForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightMagentaForeground
    override fun build(): String = withoutArg()
}

/**
 * 96
 */
object BrightCyanForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightCyanForeground
    override fun build(): String = withoutArg()
}

/**
 * 97
 */
object BrightWhiteForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightWhiteForeground
    override fun build(): String = withoutArg()
}

sealed class BrightBackgroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(brightBackgroundColor = this)
}

/**
 * 100
 */
object BrightBlackBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightBlackBackground
    override fun build(): String = withoutArg()
}

/**
 * 101
 */
object BrightRedBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightRedBackground
    override fun build(): String = withoutArg()
}

/**
 * 102
 */
object BrightGreenBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightGreenBackground
    override fun build(): String = withoutArg()
}

/**
 * 103
 */
object BrightYellowBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightYellowBackground
    override fun build(): String = withoutArg()
}

/**
 * 104
 */
object BrightBlueBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightBlueBackground
    override fun build(): String = withoutArg()
}

/**
 * 105
 */
object BrightMagentaBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightMagentaBackground
    override fun build(): String = withoutArg()
}

/**
 * 106
 */
object BrightCyanBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightCyanBackground
    override fun build(): String = withoutArg()
}

/**
 * 107
 */
object BrightWhiteBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameters.BrightWhiteBackground
    override fun build(): String = withoutArg()
}


enum class ColorParameterMode(val mode: Int) {
    Defined(0) {
        override fun parse(arguments: List<Int>): Pair<ColorParameter, List<Int>> {
            TODO("Not yet implemented")
        }
    },
    Transparent(1) {
        override fun parse(arguments: List<Int>): Pair<ColorParameter, List<Int>> {
            TODO("Not yet implemented")
        }
    },
    Rgb(2) {
        override fun parse(arguments: List<Int>): Pair<com.uramnoil.ansies.parameter.Rgb, List<Int>> {
            val (r, g, b) = arguments.take(3).map { it.toUByte() }
            return Rgb(r, g, b) to arguments.drop(3)
        }
    },
    Cmy(3) {
        override fun parse(arguments: List<Int>): Pair<ColorParameter, List<Int>> {
            TODO("Not yet implemented")
        }
    },
    Cmyk(4) {
        override fun parse(arguments: List<Int>): Pair<ColorParameter, List<Int>> {
            TODO("Not yet implemented")
        }
    },
    IndexedColor(5) {
        override fun parse(arguments: List<Int>): Pair<com.uramnoil.ansies.parameter.IndexedColor, List<Int>> {
            val indexedColor = arguments.first().toUByte()
            return com.uramnoil.ansies.parameter.IndexedColor(indexedColor) to arguments.drop(1)
        }
    }, ;

    override fun toString(): String = mode.toString()
    abstract fun parse(arguments: List<Int>): Pair<out ColorParameter, List<Int>>
}

sealed class ColorParameter {
    companion object {
        val map = ColorParameterMode.values().associateBy { it.mode }
        fun parse(arguments: List<Int>): Pair<ColorParameter, List<Int>> {
            var left = arguments
            val mode = left.first()
            left = left.drop(1)
            return map[mode]?.parse(left) ?: throw IllegalArgumentException("Doesn't match any color modes")
        }
    }

    abstract val mode: ColorParameterMode
    abstract fun build(): String
}

data class IndexedColor(val index: UByte) : ColorParameter() {
    override val mode = ColorParameterMode.IndexedColor
    override fun build(): String = "$mode;$index"
}

data class Rgb(val red: UByte, val green: UByte, val blue: UByte) : ColorParameter() {
    override val mode = ColorParameterMode.Rgb
    override fun build(): String = "$mode;$red;$green;$blue"
}