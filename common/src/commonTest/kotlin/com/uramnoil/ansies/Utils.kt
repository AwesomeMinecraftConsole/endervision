package com.uramnoil.ansies

fun sgrWithReset(arg: String, string: String = "") = "${Char(0x1B)}[${arg}m${string}${reset.build()}"
fun sgr(arg: String) = "${Char(0x1B)}[${arg}m"