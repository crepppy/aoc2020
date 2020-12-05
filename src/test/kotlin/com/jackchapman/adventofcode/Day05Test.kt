package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day05Test {
    @Test
    fun `test boarding pass decoding to seat id`() {
        val pass1 = "FBFBBFFRLR"
        assertEquals(357, boardingPassSeat(pass1))
        val pass2 = "BFFFBBFRRR"
        assertEquals(567, boardingPassSeat(pass2))
        val pass3 = "FFFBBBFRRR"
        assertEquals(119, boardingPassSeat(pass3))
        val pass4 = "BBFFBBFRLL"
        assertEquals(820, boardingPassSeat(pass4))
    }
}