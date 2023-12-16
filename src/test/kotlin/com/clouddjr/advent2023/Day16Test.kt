package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 16")
class Day16Test {
    private val input = """
        .|...\....
        |.-.\.....
        .....|-...
        ........|.
        ..........
        .........\
        ..../.\\..
        .-.-/..|..
        .|....-|.\
        ..//.|....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day16(input).solvePart1()

            assertEquals(46, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart1()

            assertEquals(6883, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day16(input).solvePart2()

            assertEquals(51, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart2()

            assertEquals(7228, answer)
        }
    }
}