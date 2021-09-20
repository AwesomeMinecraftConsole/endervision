package com.uramnoil.ansies

import com.uramnoil.ansies.parameter.*
import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiesTest {
    @Test
    fun testSgrOfBlack() {
        assertEquals(
            sgrWithReset("3"),
            (ansiOf(BlackForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfRed() {
        assertEquals(
            sgrWithReset("31"),
            (ansiOf(RedForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfGreen() {
        assertEquals(
            sgrWithReset("32"),
            (ansiOf(GreenForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfYellow() {
        assertEquals(
            sgrWithReset("33"),
            (ansiOf(YellowForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfBlue() {
        assertEquals(
            sgrWithReset("34"),
            (ansiOf(BlueForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfMagenta() {
        assertEquals(
            sgrWithReset("35"),
            (ansiOf(MagentaForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfCyan() {
        assertEquals(
            sgrWithReset("36"),
            (ansiOf(CyanForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfWhite() {
        assertEquals(
            sgrWithReset("37"),
            (ansiOf(WhiteForeground) + reset).build()
        )
    }

    @Test
    fun testSgrOfPalette() {
        assertEquals(
            sgrWithReset("38;5;0"),
            (ansiOf(SelectForegroundColor(0u)) + reset).build()
        )
    }

    @Test
    fun testSgrOfRgb() {
        assertEquals(
            sgrWithReset("38;2;0;100;200"),
            (ansiOf(SelectForegroundColorRgb(0u, 100u, 200u)) + reset).build()
        )
    }

    @Test
    fun testSgrOfAnsiEscapeBuilderPlus() {
        assertEquals(
            sgr("30") + "hoge" + sgrWithReset("37", "fuga"),
            (ansiOf(BlackBackground) + "hoge" + ansiOf(WhiteForeground) + "fuga" + reset).build()
        )
    }

    @Test
    fun testSgrOfMultipleSgr() {

    }

    @Test
    fun testSgrOfParseAnsi() {
    }
}