package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 17")
class Day17Test {
    private val input = """
        2413432311323
        3215453535623
        3255245654254
        3446585845452
        4546657867536
        1438598798454
        4457876987766
        3637877979653
        4654967986887
        4564679986453
        1224686865563
        2546548887735
        4322674655533
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart1()

            assertEquals(102, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart1()

            assertEquals(814, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart2()

            assertEquals(94, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart2()

            assertEquals(974, answer)
        }
    }
}