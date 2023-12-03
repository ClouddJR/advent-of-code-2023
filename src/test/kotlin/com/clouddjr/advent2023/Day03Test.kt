package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {
    private val input = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart1()

            assertEquals(4361, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart1()

            assertEquals(525_911, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart2()

            assertEquals(467_835, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart2()

            assertEquals(75_805_607, answer)
        }
    }
}