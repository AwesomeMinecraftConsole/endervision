package com.uramnoil.ansies

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
    SetForegroundColorBlack(30),
    SetForegroundColorRed(31),
    SetForegroundColorGreen(32),
    SetForegroundColorYellow(33),
    SetForegroundColorBlue(34),
    SetForegroundColorMagenta(35),
    SetForegroundColorCyan(36),
    SetForegroundColorWhite(37),
    SetForegroundColor(38),
    DefaultForegroundColor(39),
    SetBackgroundColorBlack(40),
    SetBackgroundColorRed(41),
    SetBackgroundColorGreen(42),
    SetBackgroundColorYellow(43),
    SetBackgroundColorBlue(44),
    SetBackgroundColorMagenta(45),
    SetBackgroundColorCyan(46),
    SetBackgroundColorWhite(47),
    SetBackgroundColor(48),
    DefaultBackgroundColor(49),
    DisableProportionalSpacing(50),
    Framed(51),
    Encircled(52),
    Overlined(53),
    NeitherFramedNorEncircled(54),
    NotOverlined(55),
    SetUnderlineColor(58),
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
    SetBrightForegroundColorBlack(90),
    SetBrightForegroundColorRed(91),
    SetBrightForegroundColorGreen(92),
    SetBrightForegroundColorYellow(93),
    SetBrightForegroundColorBlue(94),
    SetBrightForegroundColorMagenta(95),
    SetBrightForegroundColorCyan(96),
    SetBrightForegroundColorWhite(97),
    SetBrightBackgroundColorBlack(100),
    SetBrightBackgroundColorRed(101),
    SetBrightBackgroundColorGreen(102),
    SetBrightBackgroundColorYellow(103),
    SetBrightBackgroundColorBlue(104),
    SetBrightBackgroundColorMagenta(105),
    SetBrightBackgroundColorCyan(106),
    SetBrightBackgroundColorWhite(107), ;

    override fun toString(): String = m.toString()
}

sealed class SelectGraphicRenditionParameter {
    abstract val type: SelectGraphicRenditionParameterType
    abstract override fun toString(): String
}

fun SelectGraphicRenditionParameter.withoutArg() = type.toString()

class ResetOrNormal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ResetOrNormal
    override fun toString(): String = withoutArg()
}

class BoldOrIncreasedIntensity : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.BoldOrIncreasedIntensity
    override fun toString(): String = withoutArg()
}

class FaintDecreasedIntensityOrDim : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.FaintDecreasedIntensityOrDim
    override fun toString(): String = withoutArg()
}

class Italic : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Italic
    override fun toString(): String = withoutArg()
}

class Underline : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Underline
    override fun toString(): String = withoutArg()
}

class SlowBlink : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SlowBlink
    override fun toString(): String = withoutArg()
}

class RapidBlink : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.RapidBlink
    override fun toString(): String = withoutArg()
}

class ReverseVideoOrInvert : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ReverseVideoOrInvert
    override fun toString(): String = withoutArg()
}

class ConcealOrHide : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ConcealOrHide
    override fun toString(): String = withoutArg()
}

class CrossedOutOrStrike : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.CrossedOutOrStrike
    override fun toString(): String = withoutArg()
}

class PrimaryFont : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.PrimaryFont
    override fun toString(): String = withoutArg()
}

class AlternativeFont1 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont1
    override fun toString(): String = withoutArg()
}

class AlternativeFont2 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont2
    override fun toString(): String = withoutArg()
}

class AlternativeFont3 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont3
    override fun toString(): String = withoutArg()
}

class AlternativeFont4 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont4
    override fun toString(): String = withoutArg()
}

class AlternativeFont5 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont5
    override fun toString(): String = withoutArg()
}

class AlternativeFont6 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont6
    override fun toString(): String = withoutArg()
}

class AlternativeFont7 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont7
    override fun toString(): String = withoutArg()
}

class AlternativeFont8 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont8
    override fun toString(): String = withoutArg()
}

class AlternativeFont9 : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.AlternativeFont9
    override fun toString(): String = withoutArg()
}

class BlackletterFont : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.BlackletterFont
    override fun toString(): String = withoutArg()
}

class DoublyUnderlinedOrNotBold : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DoublyUnderlinedOrNotBold
    override fun toString(): String = withoutArg()
}

class NormalIntensity : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NormalIntensity
    override fun toString(): String = withoutArg()
}

class NeitherItalicNorBlackletter : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherItalicNorBlackletter
    override fun toString(): String = withoutArg()
}

class NotUnderlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotUnderlined
    override fun toString(): String = withoutArg()
}

class NotBlinking : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotBlinking
    override fun toString(): String = withoutArg()
}

class ProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.ProportionalSpacing
    override fun toString(): String = withoutArg()
}

class NotReversed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotReversed
    override fun toString(): String = withoutArg()
}

class Reveal : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Reveal
    override fun toString(): String = withoutArg()
}

class NotCrossedOut : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotCrossedOut
    override fun toString(): String = withoutArg()
}

class SetForegroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlack
    override fun toString(): String = withoutArg()
}

class SetForegroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorRed
    override fun toString(): String = withoutArg()
}

class SetForegroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorGreen
    override fun toString(): String = withoutArg()
}

class SetForegroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorYellow
    override fun toString(): String = withoutArg()
}

class SetForegroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorBlue
    override fun toString(): String = withoutArg()
}

class SetForegroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorMagenta
    override fun toString(): String = withoutArg()
}

class SetForegroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorCyan
    override fun toString(): String = withoutArg()
}

class SetForegroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColorWhite
    override fun toString(): String = withoutArg()
}

class SetForegroundColor(val parameter: ColorParameter) : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetForegroundColor
    override fun toString(): String = "$type;$parameter"
}

class DefaultForegroundColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DefaultForegroundColor
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlack
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorRed
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorGreen
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorYellow
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorBlue
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorMagenta
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorCyan
    override fun toString(): String = withoutArg()
}

class SetBackgroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColorWhite
    override fun toString(): String = withoutArg()
}

class SetBackgroundColor(val parameter: ColorParameter) : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBackgroundColor
    override fun toString(): String = "$type;$parameter"
}

class DefaultBackgroundColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DefaultBackgroundColor
    override fun toString(): String = withoutArg()
}

class DisableProportionalSpacing : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DisableProportionalSpacing
    override fun toString(): String = withoutArg()
}

class Framed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Framed
    override fun toString(): String = withoutArg()
}

class Encircled : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Encircled
    override fun toString(): String = withoutArg()
}

class Overlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Overlined
    override fun toString(): String = withoutArg()
}

class NeitherFramedNorEncircled : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherFramedNorEncircled
    override fun toString(): String = withoutArg()
}

class NotOverlined : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NotOverlined
    override fun toString(): String = withoutArg()
}

class SetUnderlineColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetUnderlineColor
    override fun toString(): String = withoutArg()
}

class DefaultUnderlineColor : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.DefaultUnderlineColor
    override fun toString(): String = withoutArg()
}

class IdeogramUnderlineOrRightSideLine : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramUnderlineOrRightSideLine
    override fun toString(): String = withoutArg()
}

class IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleUnderlineOrDoubleLineOnTheRightSide
    override fun toString(): String = withoutArg()
}

class IdeogramOverlineOrLeftSideLine : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramOverlineOrLeftSideLine
    override fun toString(): String = withoutArg()
}

class IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramDoubleOverlineOrDoubleLineOnTheLeftSide
    override fun toString(): String = withoutArg()
}

class IdeogramStressMarking : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.IdeogramStressMarking
    override fun toString(): String = withoutArg()
}

class NoIdeogramAttributes : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NoIdeogramAttributes
    override fun toString(): String = withoutArg()
}

class Superscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Superscript
    override fun toString(): String = withoutArg()
}

class Subscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.Subscript
    override fun toString(): String = withoutArg()
}

class NeitherSuperscriptNorSubscript : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.NeitherSuperscriptNorSubscript
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlack
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorRed
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorGreen
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorYellow
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorBlue
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorMagenta
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorCyan
    override fun toString(): String = withoutArg()
}

class SetBrightForegroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightForegroundColorWhite
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorBlack : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlack
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorRed : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorRed
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorGreen : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorGreen
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorYellow : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorYellow
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorBlue : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorBlue
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorMagenta : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorMagenta
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorCyan : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorCyan
    override fun toString(): String = withoutArg()
}

class SetBrightBackgroundColorWhite : SelectGraphicRenditionParameter() {
    override val type = SelectGraphicRenditionParameterType.SetBrightBackgroundColorWhite
    override fun toString(): String = withoutArg()
}


enum class ColorMode(val mode: Int) {
    Bit8(5),
    Bit24(2), ;

    override fun toString(): String = mode.toString()
}

sealed class ColorParameter {
    abstract val mode: ColorMode
    abstract override fun toString(): String
}

class Mode8ColorParameter(val color: Int) : ColorParameter() {
    override val mode = ColorMode.Bit8
    override fun toString(): String = "$mode;$color"
}

class Mode24ColorParameter(val red: Int, val green: Int, val blue: Int) : ColorParameter() {
    override val mode = ColorMode.Bit24
    override fun toString(): String = "$mode;$red;$green;$blue"
}