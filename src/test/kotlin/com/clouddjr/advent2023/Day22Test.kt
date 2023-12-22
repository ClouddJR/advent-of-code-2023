package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 22")
class Day22Test {
    private val input = """
        1,0,1~1,2,1
        0,0,2~2,0,2
        0,2,3~2,2,3
        0,0,4~0,2,4
        2,0,5~2,2,5
        0,1,6~2,1,6
        1,1,8~1,1,9
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day22(input).solvePart1()

            assertEquals(5, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart1()

            assertEquals(391, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day22(input).solvePart2()

            assertEquals(7, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart2()

            assertEquals(69_601, answer)
        }
    }
}