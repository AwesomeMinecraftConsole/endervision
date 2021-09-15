package com.uramnoil.ansies.parameter

import com.uramnoil.ansies.SelectGraphicRenditionSequence

enum class SelectGraphicRenditionParameterType(val m: Int) {
    ResetOrNormal(0),
    BoldOrIncreasedIntensity(1),
    FaintDecreasedIntensityOrDim(2),
    Italic(3),
    Underline(4),
    SlowBlink(5),
    RapidBlink(6),
    ReverseVideoOrInvert(7),
    ConcealOrHide(8),
    CrossedOutOrStrike(9),
    PrimaryFont(10),
    AlternativeFont1(11),
    AlternativeFont2(12),
    AlternativeFont3(13),
    AlternativeFont4(14),
    AlternativeFont5(15),
    AlternativeFont6(16),
    AlternativeFont7(17),
    AlternativeFont8(18),
    AlternativeFont9(19),
    BlackletterFont(20),
    DoublyUnderlinedOrNotBold(21),
    NormalIntensity(22),
    NeitherItalicNorBlackletter(23),
    NotUnderlined(24),
    NotBlinking(25),
    ProportionalSpacing(26),
    NotReversed(27),
    Reveal(28),
    NotCrossedOut(29),
    ForegroundColorBlack(30),
    ForegroundColorRed(31),
    ForegroundColorGreen(32),
    ForegroundColorYellow(33),
    ForegroundColorBlue(34),
    ForegroundColorMagenta(35),
    ForegroundColorCyan(36),
    ForegroundColorWhite(37),
    ForegroundColor(38),
    DefaultForegroundColor(39),
    BackgroundColorBlack(40),
    BackgroundColorRed(41),
    BackgroundColorGreen(42),
    BackgroundColorYellow(43),
    BackgroundColorBlue(44),
    BackgroundColorMagenta(45),
    BackgroundColorCyan(46),
    BackgroundColorWhite(47),
    BackgroundColor(48),
    DefaultBackgroundColor(49),
    DisableProportionalSpacing(50),
    Framed(51),
    Encircled(52),
    Overlined(53),
    NeitherFramedNorEncircled(54),
    NotOverlined(55),
    UnderlineColor(58),
    DefaultUnderlineColor(59),
    IdeogramUnderlineOrRightSideLine(60),
    IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide(61),
    IdeogramOverlineOrLeftSideLine(62),
    IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide(63),
    IdeogramStressMarking(64),
    NoIdeogramAttributes(65),
    Superscript(73),
    Subscript(74),
    NeitherSuperscriptNorSubscript(75),
    BrightForegroundColorBlack(90),
    BrightForegroundColorRed(91),
    BrightForegroundColorGreen(92),
    BrightForegroundColorYellow(93),
    BrightForegroundColorBlue(94),
    BrightForegroundColorMagenta(95),
    BrightForegroundColorCyan(96),
    BrightForegroundColorWhite(97),
    BrightBackgroundColorBlack(100),
    BrightBackgroundColorRed(101),
    BrightBackgroundColorGreen(102),
    BrightBackgroundColorYellow(103),
    BrightBackgroundColorBlue(104),
    BrightBackgroundColorMagenta(105),
    BrightBackgroundColorCyan(106),
    BrightBackgroundColorWhite(107), ;

    override fun toString(): String = m.toString()
}

sealed class SelectGraphicRenditionParameter {
    abstract val type: SelectGraphicRenditionParameterType
    abstract fun build(): String
    abstract fun asSequence(): SelectGraphicRenditionSequence
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

/**
 * 0
 */
object ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ResetOrNormal
    override fun build(): String = withoutArg()
    override fun asSequence() = SelectGraphicRenditionSequence(startWithReset = this)
}

sealed class Intensity : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(intensity = this)
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
    override fun asSequence() = SelectGraphicRenditionSequence(penmanship = this)
}

/**
 * 3
 */
object Italicized : Penmanship() {
    override val type = SelectGraphicRenditionParameterType.Italic
    override fun build(): String = withoutArg()
}

sealed class Underline : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(underline = this)
}

/**
 * 4
 */
object Underlined : Underline() {
    override val type = SelectGraphicRenditionParameterType.Underline
    override fun build(): String = withoutArg()
}

sealed class Blink : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(blink = this)
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
    override fun asSequence() = SelectGraphicRenditionSequence(reverse = this)
}

/**
 * 7
 */
object Reversed : Reverse() {
    override val type = SelectGraphicRenditionParameterType.ReverseVideoOrInvert
    override fun build(): String = withoutArg()
}

sealed class Conceal : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(conceal = this)
}

/**
 * 8
 */
object Concealed : Conceal() {
    override val type = SelectGraphicRenditionParameterType.ConcealOrHide
    override fun build(): String = withoutArg()
}

sealed class CrossOut : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(crossedOut = this)
}

/**
 * 9
 */
object CrossedOut : CrossOut() {
    override val type = SelectGraphicRenditionParameterType.CrossedOutOrStrike
    override fun build(): String = withoutArg()
}

sealed class Font : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(font = this)
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
object NeitherItalicNorFraktur : Font() {
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
object Steady : Blink() {
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
    override fun asSequence(): SelectGraphicRenditionSequence {
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
    override fun asSequence() = SelectGraphicRenditionSequence(foregroundColor = this)
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
class SelectForegroundColor(val parameter: ColorParameter) : ForegroundColor() {
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
    override fun asSequence() = SelectGraphicRenditionSequence(backgroundColor = this)
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
class SelectBackgroundColor(val parameter: ColorParameter) : BackgroundColor() {
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
    override fun asSequence(): SelectGraphicRenditionSequence {
        TODO("Not yet implemented")
    }
}

sealed class EmojiStyle : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(emojiVariation = this)
}

/**
 * 51
 */
object Framed : EmojiStyle() {
    override val type = SelectGraphicRenditionParameterType.Framed
    override fun build(): String = withoutArg()
}

/**
 * 52
 */
object Encircled : EmojiStyle() {
    override val type = SelectGraphicRenditionParameterType.Encircled
    override fun build(): String = withoutArg()
}

sealed class Overline : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(overline = this)
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
object NeitherFramedNorEncircled : EmojiStyle() {
    override val type = SelectGraphicRenditionParameterType.NeitherFramedNorEncircled
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
    override fun asSequence() = SelectGraphicRenditionSequence(underlineColor = this)
}

/**
 * 58
 */
class UnderlineColor(val parameter: IndexedColor) : UnderLineColor() {
    override val type = SelectGraphicRenditionParameterType.UnderlineColor
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
    override fun asSequence() = SelectGraphicRenditionSequence(ideogram = this)
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
object NoIdeogramAttributes : Ideogram() {
    override val type = SelectGraphicRenditionParameterType.NoIdeogramAttributes
    override fun build(): String = withoutArg()
}

sealed class Script : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(script = this)
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
object NeitherSuperscriptNorSubscript : Script() {
    override val type = SelectGraphicRenditionParameterType.NeitherSuperscriptNorSubscript
    override fun build(): String = withoutArg()
}

sealed class BrightForegroundColor : SelectGraphicRenditionParameter() {
    override fun asSequence() = SelectGraphicRenditionSequence(brightForegroundColor = this)
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
    override fun asSequence() = SelectGraphicRenditionSequence(brightBackgroundColor = this)
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
    Defined(0),
    Transparent(1),
    Rgb(2),
    Cmy(3),
    Cmyk(4),
    IndexedColor(5), ;

    override fun toString(): String = mode.toString()
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