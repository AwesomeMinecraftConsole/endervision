package com.uramnoil.ansies

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiesTest {
    companion object {
        fun csiWithReset(arg: String, string: String = "") = "${Char(0x1B)}[${arg}m${string}${reset.build()}"
        fun csi(arg: String, string: String) = "${Char(0x1B)}[${arg}m${string}"
    }

    @Test
    fun testBlack() {
        assertEquals(
            csiWithReset("30"),
            "".black().build()
        )
    }

    @Test
    fun testRed() {
        assertEquals(
            csiWithReset("31"),
            "".red().build()
        )
    }

    @Test
    fun testGreen() {
        assertEquals(
            csiWithReset("32"),
            "".green().build()
        )
    }

    @Test
    fun testYellow() {
        assertEquals(
            csiWithReset("33"),
            "".yellow().build()
        )
    }

    @Test
    fun testBlue() {
        assertEquals(
            csiWithReset("34"),
            "".blue().build()
        )
    }

    @Test
    fun testMagenta() {
        assertEquals(
            csiWithReset("35"),
            "".magenta().build()
        )
    }

    @Test
    fun testCyan() {
        assertEquals(
            csiWithReset("36"),
            "".cyan().build()
        )
    }

    @Test
    fun testWhite() {
        assertEquals(
            csiWithReset("37"),
            "".white().build()
        )
    }

    @Test
    fun testColorPalette() {
        assertEquals(
            csiWithReset("38;5;0"),
            "".colorPalette(0u).build()
        )
    }

    @Test
    fun testRgb() {
        assertEquals(
            csiWithReset("38;2;0;100;200"),
            "".rgb(0u, 100u, 200u).build()
        )
    }

    @Test
    fun testAnsiEscapeBuilderPlus() {
        assertEquals(
            csi("30", "hoge") + csiWithReset("37", "fuga"),
            ("hoge".black() + "fuga".white()).build()
        )
    }
}