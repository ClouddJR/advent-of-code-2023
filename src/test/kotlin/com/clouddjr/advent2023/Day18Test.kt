package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 18")
class Day18Test {
    private val input = """
        R 6 (#70c710)
        D 5 (#0dc571)
        L 2 (#5713f0)
        D 2 (#d2c081)
        R 2 (#59c680)
        D 2 (#411b91)
        L 5 (#8ceee2)
        U 2 (#caa173)
        L 1 (#1b58a2)
        U 2 (#caa171)
        R 2 (#7807d2)
        U 3 (#a77fa3)
        L 2 (#015232)
        U 2 (#7a21e3)
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day18(input).solvePart1()

            assertEquals(62, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart1()

            assertEquals(34_329, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day18(input).solvePart2()

            assertEquals(952_408_144_115, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart2()

            assertEquals(42_617_947_302_920, answer)
        }
    }
}