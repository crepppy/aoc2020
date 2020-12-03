package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayTwoTest {
    private val passwordA = "1-3 a: abcde"
    private val passwordB = "1-3 b: cdefg"
    private val passwordC = "2-9 c: ccccccccc"

    @Test
    fun `test password on number of characters`() {
        assertEquals(true, isValidCount(passwordA))
        assertEquals(false, isValidCount(passwordB))
        assertEquals(true, isValidCount(passwordC))
    }

    @Test
    fun `test password on position of characters`() {
        assertEquals(true, isValidPosition(passwordA))
        assertEquals(false, isValidPosition(passwordB))
        assertEquals(false, isValidPosition(passwordC))
    }
}