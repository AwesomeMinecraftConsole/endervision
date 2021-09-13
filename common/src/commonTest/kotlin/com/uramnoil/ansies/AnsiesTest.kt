package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*
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
             (sgrOf(SetForegroundColorBlack) + reset).build()
        )
    }

    @Test
    fun testRed() {
        assertEquals(
            csiWithReset("31"),
             (sgrOf(SetForegroundColorRed) + reset).build()
        )
    }

    @Test
    fun testGreen() {
        assertEquals(
            csiWithReset("32"),
             (sgrOf(SetForegroundColorGreen) + reset).build()
        )
    }

    @Test
    fun testYellow() {
        assertEquals(
            csiWithReset("33"),
             (sgrOf(SetForegroundColorYellow) + reset).build()
        )
    }

    @Test
    fun testBlue() {
        assertEquals(
            csiWithReset("34"),
             (sgrOf(SetForegroundColorBlue) + reset).build()
        )
    }

    @Test
    fun testMagenta() {
        assertEquals(
            csiWithReset("35"),
             (sgrOf(SetForegroundColorMagenta) + reset).build()
        )
    }

    @Test
    fun testCyan() {
        assertEquals(
            csiWithReset("36"),
             (sgrOf(SetForegroundColorCyan) + reset).build()
        )
    }

    @Test
    fun testWhite() {
        assertEquals(
            csiWithReset("37"),
             (sgrOf(SetForegroundColorWhite) + reset).build()
        )
    }

    @Test
    fun testColorPalette() {
        assertEquals(
            csiWithReset("38;5;0"),
            (sgrOf(SetForegroundColorWith(0u)) + reset).build()
        )
    }

    @Test
    fun testRgb() {
        assertEquals(
            csiWithReset("38;2;0;100;200"),
            (sgrOf(SetForegroundColorWith(0u, 100u, 200u)) + reset).build()
        )
    }

    @Test
    fun testAnsiEscapeBuilderPlus() {
        assertEquals(
            csi("30", "hoge") + csiWithReset("37", "fuga"),
            (sgrOf(SetForegroundColorBlack) + "hoge" + sgrOf(SetForegroundColorWhite) + "fuga" + reset).build()
        )
    }

    @Test
    fun testMultipleSgr() {
    }

    @Test
    fun testParseAnsi() {
    }
}