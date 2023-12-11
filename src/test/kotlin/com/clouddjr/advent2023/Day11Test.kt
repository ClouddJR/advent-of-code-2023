package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
class Day11Test {
    private val input = """
        ...#......
        .......#..
        #.........
        ..........
        ......#...
        .#........
        .........#
        ..........
        .......#..
        #...#.....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart1()

            assertEquals(374, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart1()

            assertEquals(9_312_968, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart2()

            assertEquals(82_000_210, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart2()

            assertEquals(597_714_117_556, answer)
        }
    }
}