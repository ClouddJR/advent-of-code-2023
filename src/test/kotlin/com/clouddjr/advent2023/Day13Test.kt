package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 13")
class Day13Test {
    private val input = """
        #.##..##.
        ..#.##.#.
        ##......#
        ##......#
        ..#.##.#.
        ..##..##.
        #.#.##.#.

        #...##..#
        #....#..#
        ..##..###
        #####.##.
        #####.##.
        ..##..###
        #....#..#
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day13(input).solvePart1()

            assertEquals(405, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsText("day13.txt")).solvePart1()

            assertEquals(37_113, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day13(input).solvePart2()

            assertEquals(400, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsText("day13.txt")).solvePart2()

            assertEquals(30_449, answer)
        }
    }
}