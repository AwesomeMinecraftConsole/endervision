package com.uramnoil.ansies.parameter

import androidx.compose.ui.graphics.Color

enum class SelectGraphicRenditionParameterType(val m: Int) {
    ResetOrNormal(0) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BoldOrIncreasedIntensity(1) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    FaintDecreasedIntensityOrDim(2) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Italicized(3) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Underline(4) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    SlowBlink(5) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    RapidBlink(6) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Reversed(7) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ConcealOrHide(8) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    CrossedOut(9) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    PrimaryFont(10) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont1(11) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont2(12) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont3(13) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont4(14) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont5(15) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont6(16) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont7(17) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont8(18) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    AlternativeFont9(19) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BlackletterFont(20) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    DoublyUnderlinedOrNotBold(21) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NormalIntensity(22) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NeitherItalicNorBlackletter(23) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NotUnderlined(24) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NotBlinking(25) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ProportionalSpacing(26) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NotReversed(27) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Reveal(28) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NotCrossedOut(29) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorBlack(30) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorRed(31) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorGreen(32) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorYellow(33) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorBlue(34) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorMagenta(35) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorCyan(36) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColorWhite(37) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ForegroundColor(38) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    DefaultForegroundColor(39) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorBlack(40) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorRed(41) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorGreen(42) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorYellow(43) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorBlue(44) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorMagenta(45) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorCyan(46) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColorWhite(47) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BackgroundColor(48) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    DefaultBackgroundColor(49) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    DisableProportionalSpacing(50) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Framed(51) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Encircled(52) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Overlined(53) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    ResetEmojiVariation(54) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NotOverlined(55) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    SelectUnderlineColor(58) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    DefaultUnderlineColor(59) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    IdeogramUnderlineOrRightSideLine(60) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide(61) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    IdeogramOverlineOrLeftSideLine(62) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide(63) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    IdeogramStressMarking(64) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NoIdeogramAttribute(65) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Superscript(73) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    Subscript(74) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    NeitherSuperscriptNorSubscript(75) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorBlack(90) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorRed(91) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorGreen(92) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorYellow(93) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorBlue(94) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorMagenta(95) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorCyan(96) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightForegroundColorWhite(97) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorBlack(100) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorRed(101) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorGreen(102) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorYellow(103) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorBlue(104) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorMagenta(105) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorCyan(106) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    },
    BrightBackgroundColorWhite(107) {
        override fun parse(string: String): SelectGraphicRenditionParameter {
            TODO("Not yet implemented")
        }
    }, ;

    override fun toString(): String = m.toString()
    abstract fun parse(string: String): SelectGraphicRenditionParameter
}

sealed class SelectGraphicRenditionParameter {
    abstract val type: SelectGraphicRenditionParameterType
    abstract fun build(): String
    abstract fun asSequence(): SelectGraphicRendition
    var string: String = ""
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

/**
 * 0
 */
object ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ResetOrNormal
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
    override val type = SelectGraphicRenditionParameterType.BoldOrIncreasedIntensity
    override fun build(): String = withoutArg()
}

/**
 * 2
 */
object FaintDecreasedIntensityOrDim : Intensity() {
    override val type = SelectGraphicRenditionParameterType.FaintDecreasedIntensityOrDim
    override fun build(): String = withoutArg()
}

sealed class Penmanship : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(penmanship = this)
}

/**
 * 3
 */
object Italicized : Penmanship() {
    override val type = SelectGraphicRenditionParameterType.Italicized
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
    override val type = SelectGraphicRenditionParameterType.Underline
    override fun build(): String = withoutArg()
}

sealed class Blink : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(blink = this)
}

/**
 * 5
 */
object SlowlyBlinking : Blink() {
    override val type = SelectGraphicRenditionParameterType.SlowBlink
    override fun build(): String = withoutArg()
}

/**
 * 6
 */
object RapidlyBlinking : Blink() {
    override val type = SelectGraphicRenditionParameterType.RapidBlink
    override fun build(): String = withoutArg()
}

sealed class Reverse : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(reverse = this)
}

/**
 * 7
 */
object Reversed : Reverse() {
    override val type = SelectGraphicRenditionParameterType.Reversed
    override fun build(): String = withoutArg()
}

sealed class Conceal : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(conceal = this)
}

/**
 * 8
 */
object Concealed : Conceal() {
    override val type = SelectGraphicRenditionParameterType.ConcealOrHide
    override fun build(): String = withoutArg()
}

sealed class CrossOut : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(crossedOut = this)
}

/**
 * 9
 */
object CrossedOut : CrossOut() {
    override val type = SelectGraphicRenditionParameterType.CrossedOut
    override fun build(): String = withoutArg()
}

sealed class Font : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(font = this)
}

/**
 * 10
 */
object PrimaryFont : Font() {
    override val type = SelectGraphicRenditionParameterType.PrimaryFont
    override fun build(): String = withoutArg()
}

/**
 * 11
 */
object AlternativeFont1 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont1
    override fun build(): String = withoutArg()
}

/**
 * 12
 */
object AlternativeFont2 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont2
    override fun build(): String = withoutArg()
}

/**
 * 13
 */
object AlternativeFont3 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont3
    override fun build(): String = withoutArg()
}

/**
 * 14
 */
object AlternativeFont4 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont4
    override fun build(): String = withoutArg()
}

/**
 * 15
 */
object AlternativeFont5 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont5
    override fun build(): String = withoutArg()
}

/**
 * 16
 */
object AlternativeFont6 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont6
    override fun build(): String = withoutArg()
}

/**
 * 17
 */
object AlternativeFont7 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont7
    override fun build(): String = withoutArg()
}

/**
 * 18
 */
object AlternativeFont8 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont8
    override fun build(): String = withoutArg()
}

/**
 * 19
 */
object AlternativeFont9 : Font() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont9
    override fun build(): String = withoutArg()
}

/**
 * 20
 */
object Fraktur : Penmanship() {
    override val type = SelectGraphicRenditionParameterType.BlackletterFont
    override fun build(): String = withoutArg()
}

/**
 * 21
 */
object DoublyUnderlined : Underline() {
    override val type = SelectGraphicRenditionParameterType.DoublyUnderlinedOrNotBold
    override fun build(): String = withoutArg()
}

/**
 * 22
 */
object NormalIntensity : Intensity() {
    override val type = SelectGraphicRenditionParameterType.NormalIntensity
    override fun build(): String = withoutArg()
}

/**
 * 23
 */
object ResetPenmanship : Penmanship() {
    override val type = SelectGraphicRenditionParameterType.NeitherItalicNorBlackletter
    override fun build(): String = withoutArg()
}

/**
 * 24
 * Neither singly nor doubly
 */
object NotUnderlined : Underline() {
    override val type = SelectGraphicRenditionParameterType.NotUnderlined
    override fun build(): String = withoutArg()
}

/**
 * 25
 * Disable blinking
 */
object NotBlinking : Blink() {
    override val type = SelectGraphicRenditionParameterType.NotBlinking
    override fun build(): String = withoutArg()
}

/**
 * 26
 * Reserved for proportional spacing as specified in the CCITT Recommendation.
 * In other words, it's not in use now.
 */
object ProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ProportionalSpacing
    override fun build(): String = withoutArg()
    override fun asSequence(): SelectGraphicRendition {
        TODO("Not yet implemented")
    }
}

/**
 * 27
 */
object NotReversed : Reverse() {
    override val type = SelectGraphicRenditionParameterType.NotReversed
    override fun build(): String = withoutArg()
}

/**
 * 28
 */
object Revealed : Conceal() {
    override val type = SelectGraphicRenditionParameterType.Reveal
    override fun build(): String = withoutArg()
}

/**
 * 29
 */
object NotCrossedOut : CrossOut() {
    override val type = SelectGraphicRenditionParameterType.NotCrossedOut
    override fun build(): String = withoutArg()
}

sealed class ForegroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(foregroundColor = this)
}

/**
 * 30
 */
object BlackForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorBlack
    override fun build(): String = withoutArg()
}

/**
 * 31
 */
object RedForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorRed
    override fun build(): String = withoutArg()
}

/**
 * 32
 */
object GreenForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorGreen
    override fun build(): String = withoutArg()
}

/**
 * 33
 */
object YellowForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorYellow
    override fun build(): String = withoutArg()
}

/**
 * 34
 */
object BlueForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorBlue
    override fun build(): String = withoutArg()
}

/**
 * 35
 */
object MagentaForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorMagenta
    override fun build(): String = withoutArg()
}

/**
 * 36
 */
object CyanForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorCyan
    override fun build(): String = withoutArg()
}

/**
 * 37
 */
object WhiteForeground : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColorWhite
    override fun build(): String = withoutArg()
}

/**
 * 38
 */
data class SelectForegroundColor(val parameter: ColorParameter) : ForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.ForegroundColor
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
    override val type = SelectGraphicRenditionParameterType.DefaultForegroundColor
    override fun build(): String = withoutArg()
}

sealed class BackgroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(backgroundColor = this)
}

/**
 * 40
 */
object BlackBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorBlack
    override fun build(): String = withoutArg()
}

/**
 * 41
 */
object RedBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorRed
    override fun build(): String = withoutArg()
}

/**
 * 42
 */
object GreenBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorGreen
    override fun build(): String = withoutArg()
}

/**
 * 43
 */
object YellowBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorYellow
    override fun build(): String = withoutArg()
}

/**
 * 44
 */
object BlueBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorBlue
    override fun build(): String = withoutArg()
}

/**
 * 45
 */
object MagentaBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorMagenta
    override fun build(): String = withoutArg()
}

/**
 * 46
 */
object CyanBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorCyan
    override fun build(): String = withoutArg()
}

/**
 * 47
 */
object WhiteBackground : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColorWhite
    override fun build(): String = withoutArg()
}

/**
 * 48
 */
data class SelectBackgroundColor(val parameter: ColorParameter) : BackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BackgroundColor
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
    override val type = SelectGraphicRenditionParameterType.DefaultBackgroundColor
    override fun build(): String = withoutArg()
}

/**
 * 50
 */
object NotVariableSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DisableProportionalSpacing
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
    override val type = SelectGraphicRenditionParameterType.Framed
    override fun build(): String = withoutArg()
}

/**
 * 52
 */
object Encircled : EmojiVariation() {
    override val type = SelectGraphicRenditionParameterType.Encircled
    override fun build(): String = withoutArg()
}

sealed class Overline : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(overline = this)
}

/**
 * 53
 */
object Overlined : Overline() {
    override val type = SelectGraphicRenditionParameterType.Overlined
    override fun build(): String = withoutArg()
}

/**
 * 54
 */
object ResetEmojiVariation : EmojiVariation() {
    override val type = SelectGraphicRenditionParameterType.ResetEmojiVariation
    override fun build(): String = withoutArg()
}

/**
 * 55
 */
object NotOverlined : Overline() {
    override val type = SelectGraphicRenditionParameterType.NotOverlined
    override fun build(): String = withoutArg()
}

sealed class UnderLineColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(underlineColor = this)
}

/**
 * 58
 */
data class SelectUnderlineColor(val parameter: IndexedColor) : UnderLineColor() {
    override val type = SelectGraphicRenditionParameterType.SelectUnderlineColor
    override fun build(): String = type.toString() + parameter.build()
}

/**
 * 59
 */
object DefaultUnderlineColor : UnderLineColor() {
    override val type = SelectGraphicRenditionParameterType.DefaultUnderlineColor
    override fun build(): String = withoutArg()
}

sealed class Ideogram : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(ideogram = this)
}

/**
 * 60
 */
object IdeogramUnderlineOrRightSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramUnderlineOrRightSideLine
    override fun build(): String = withoutArg()
}

/**
 * 61
 */
object IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide
    override fun build(): String = withoutArg()
}

/**
 * 62
 */
object IdeogramOverlineOrLeftSideLine : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramOverlineOrLeftSideLine
    override fun build(): String = withoutArg()
}

/**
 * 63
 */
object IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide
    override fun build(): String = withoutArg()
}

/**
 * 64
 */
object IdeogramStressMarking : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.IdeogramStressMarking
    override fun build(): String = withoutArg()
}

/**
 * 65
 */
object NoIdeogramAttribute : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.NoIdeogramAttribute
    override fun build(): String = withoutArg()
}

sealed class Script : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(script = this)
}

/**
 * 73
 */
object Superscript : Script() {
    override val type = SelectGraphicRenditionParameterType.Superscript
    override fun build(): String = withoutArg()
}

/**
 * 74
 */
object Subscript : Script() {
    override val type = SelectGraphicRenditionParameterType.Subscript
    override fun build(): String = withoutArg()
}

/**
 * 75
 */
object NoScriptAttribute : Script() {
    override val type = SelectGraphicRenditionParameterType.NeitherSuperscriptNorSubscript
    override fun build(): String = withoutArg()
}

sealed class BrightForegroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(brightForegroundColor = this)
}

/**
 * 90
 */
object BlackBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorBlack
    override fun build(): String = withoutArg()
}

/**
 * 91
 */
object RedBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorRed
    override fun build(): String = withoutArg()
}

/**
 * 92
 */
object GreenBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorGreen
    override fun build(): String = withoutArg()
}

/**
 * 93
 */
object YellowBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorYellow
    override fun build(): String = withoutArg()
}

/**
 * 94
 */
object BlueBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorBlue
    override fun build(): String = withoutArg()
}

/**
 * 95
 */
object MagentaBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorMagenta
    override fun build(): String = withoutArg()
}

/**
 * 96
 */
object CyanBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorCyan
    override fun build(): String = withoutArg()
}

/**
 * 97
 */
object WhiteBrightForeground : BrightForegroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightForegroundColorWhite
    override fun build(): String = withoutArg()
}

sealed class BrightBackgroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRendition(brightBackgroundColor = this)
}

/**
 * 100
 */
object BlackBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorBlack
    override fun build(): String = withoutArg()
}

/**
 * 101
 */
object RedBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorRed
    override fun build(): String = withoutArg()
}

/**
 * 102
 */
object GreenBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorGreen
    override fun build(): String = withoutArg()
}

/**
 * 103
 */
object YellowBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorYellow
    override fun build(): String = withoutArg()
}

/**
 * 104
 */
object BlueBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorBlue
    override fun build(): String = withoutArg()
}

/**
 * 105
 */
object MagentaBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorMagenta
    override fun build(): String = withoutArg()
}

/**
 * 106
 */
object CyanBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorCyan
    override fun build(): String = withoutArg()
}

/**
 * 107
 */
object WhiteBrightBackground : BrightBackgroundColor() {
    override val type = SelectGraphicRenditionParameterType.BrightBackgroundColorWhite
    override fun build(): String = withoutArg()
}


enum class ColorParameterMode(val mode: Int) {
    Defined(0) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    },
    Transparent(1) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    },
    Rgb(2) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    },
    Cmy(3) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    },
    Cmyk(4) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    },
    IndexedColor(5) {
        override fun parse(string: String): ColorParameter {
            TODO("Not yet implemented")
        }
    }, ;

    override fun toString(): String = mode.toString()
    abstract fun parse(string: String): ColorParameter
}

sealed class ColorParameter {
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