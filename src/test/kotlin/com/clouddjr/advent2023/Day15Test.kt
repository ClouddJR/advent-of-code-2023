package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 15")
class Day15Test {
    private val input = """
        rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart1()

            assertEquals(1320, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsText("day15.txt")).solvePart1()

            assertEquals(505_459, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart2()

            assertEquals(145, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsText("day15.txt")).solvePart2()

            assertEquals(228_508, answer)
        }
    }
}