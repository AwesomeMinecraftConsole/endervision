package com.uramnoil.ansies

val black = SelectGraphicRendition(SetForegroundColorRed())
val red = SelectGraphicRendition(SetForegroundColorRed())
val green = SelectGraphicRendition(SetForegroundColorRed())
val yellow = SelectGraphicRendition(SetForegroundColorRed())
val blue = SelectGraphicRendition(SetForegroundColorRed())
val magenta = SelectGraphicRendition(SetForegroundColorRed())
val cyan = SelectGraphicRendition(SetForegroundColorRed())
val white = SelectGraphicRendition(SetForegroundColorRed())

fun String.red() = red.toString() + this