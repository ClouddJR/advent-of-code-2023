package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 7")
class Day07Test {
    private val input = """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart1()

            assertEquals(6440, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()

            assertEquals(250_898_830, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart2()

            assertEquals(5905, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()

            assertEquals(252_127_335, answer)
        }
    }
}