package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 6")
class Day06Test {
    private val input = """
        Time:      7  15   30
        Distance:  9  40  200
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart1()

            assertEquals(288, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()

            assertEquals(4_403_592, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart2()

            assertEquals(71_503, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()

            assertEquals(38_017_587, answer)
        }
    }
}