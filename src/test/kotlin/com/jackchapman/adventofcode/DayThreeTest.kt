package com.jackchapman.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayThreeTest {
    private val map = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent()

    @Test
    fun `test collisions only moving vertically by one`() {
        assertEquals(2, getCollisions(map.lines()))
        assertEquals(7, getCollisions(map.lines(), 3))
        assertEquals(3, getCollisions(map.lines(), 5))
        assertEquals(4, getCollisions(map.lines(), 7))
    }

    @Test
    fun `test collisions moving both vertically and horizontally`() {
        assertEquals(2, getCollisions(map.lines(), down = 2))
    }
}