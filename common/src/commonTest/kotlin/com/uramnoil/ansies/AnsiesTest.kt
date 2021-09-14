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
    fun testSgrOfBlack() {
        assertEquals(
            csiWithReset("30"),
             (sgrOf(SetForegroundColorBlack) + reset).build()
        )
    }

    @Test
    fun testSgrOfRed() {
        assertEquals(
            csiWithReset("31"),
             (sgrOf(SetForegroundColorRed) + reset).build()
        )
    }

    @Test
    fun testSgrOfGreen() {
        assertEquals(
            csiWithReset("32"),
             (sgrOf(SetForegroundColorGreen) + reset).build()
        )
    }

    @Test
    fun testSgrOfYellow() {
        assertEquals(
            csiWithReset("33"),
             (sgrOf(SetForegroundColorYellow) + reset).build()
        )
    }

    @Test
    fun testSgrOfBlue() {
        assertEquals(
            csiWithReset("34"),
             (sgrOf(SetForegroundColorBlue) + reset).build()
        )
    }

    @Test
    fun testSgrOfMagenta() {
        assertEquals(
            csiWithReset("35"),
             (sgrOf(SetForegroundColorMagenta) + reset).build()
        )
    }

    @Test
    fun testSgrOfCyan() {
        assertEquals(
            csiWithReset("36"),
             (sgrOf(SetForegroundColorCyan) + reset).build()
        )
    }

    @Test
    fun testSgrOfWhite() {
        assertEquals(
            csiWithReset("37"),
             (sgrOf(SetForegroundColorWhite) + reset).build()
        )
    }

    @Test
    fun testSgrOfColorPalette() {
        assertEquals(
            csiWithReset("38;5;0"),
            (sgrOf(SetForegroundColorWith(0u)) + reset).build()
        )
    }

    @Test
    fun testSgrOfRgb() {
        assertEquals(
            csiWithReset("38;2;0;100;200"),
            (sgrOf(SetForegroundColorWith(0u, 100u, 200u)) + reset).build()
        )
    }

    @Test
    fun testSgrOfAnsiEscapeBuilderPlus() {
        assertEquals(
            csi("30", "hoge") + csiWithReset("37", "fuga"),
            (sgrOf(SetForegroundColorBlack) + "hoge" + sgrOf(SetForegroundColorWhite) + "fuga" + reset).build()
        )
    }

    @Test
    fun testSgrOfMultipleSgr() {
    }

    @Test
    fun testSgrOfParseAnsi() {
    }
}