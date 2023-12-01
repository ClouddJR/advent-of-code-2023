package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {
    private val part1Input = """
        1abc2
        pqr3stu8vwx
        a1b2c3d4e5f
        treb7uchet
    """.trimIndent().lines()

    private val part2Input = """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(part1Input).solvePart1()

            assertEquals(142, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart1()

            assertEquals(54_390, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(part2Input).solvePart2()

            assertEquals(281, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart2()

            assertEquals(54_277, answer)
        }
    }
}