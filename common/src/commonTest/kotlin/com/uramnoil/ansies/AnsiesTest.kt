package com.uramnoil.ansies

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiesTest {
    @Test
    fun test() {
        assertEquals(
            "${Char(0x1B)}${Char(0x9B)}31m",
            "".red().toString()
        )
    }
}