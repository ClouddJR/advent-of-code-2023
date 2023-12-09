package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {
    private val input = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart1()

            assertEquals(114, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart1()

            assertEquals(1_798_691_765, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart2()

            assertEquals(2, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart2()

            assertEquals(1104, answer)
        }
    }
}