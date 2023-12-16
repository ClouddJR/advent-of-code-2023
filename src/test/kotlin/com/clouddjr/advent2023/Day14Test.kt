package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 14")
class Day14Test {
    private val input = """
        O....#....
        O.OO#....#
        .....##...
        OO.#O....O
        .O.....O#.
        O.#..O.#.#
        ..O..#O..O
        .......O..
        #....###..
        #OO..#....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day14(input).solvePart1()

            assertEquals(136, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsListOfString("day14.txt")).solvePart1()

            assertEquals(105_982, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day14(input).solvePart2()

            assertEquals(64, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsListOfString("day14.txt")).solvePart2()

            assertEquals(85_175, answer)
        }
    }
}