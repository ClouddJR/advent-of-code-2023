package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
class Day08Test {
    private val inputPart1 = """
        LLR

        AAA = (BBB, BBB)
        BBB = (AAA, ZZZ)
        ZZZ = (ZZZ, ZZZ)
    """.trimIndent().lines()

    private val inputPart2 = """
        LR

        11A = (11B, XXX)
        11B = (XXX, 11Z)
        11Z = (11B, XXX)
        22A = (22B, XXX)
        22B = (22C, 22C)
        22C = (22Z, 22Z)
        22Z = (22B, 22B)
        XXX = (XXX, XXX)
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08(inputPart1).solvePart1()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            assertEquals(16_531, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08(inputPart2).solvePart2()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            assertEquals(24_035_773_251_517, answer)
        }
    }
}