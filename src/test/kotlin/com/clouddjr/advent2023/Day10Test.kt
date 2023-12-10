package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day10Test {
    private val inputPart1 = """
        7-F7-
        .FJ|7
        SJLL7
        |F--J
        LJ.LJ
    """.trimIndent().lines()

    private val inputPart2 = """
        FF7FSF7F7F7F7F7F---7
        L|LJ||||||||||||F--J
        FL-7LJLJ||||||LJL-77
        F--JF--7||LJLJ7F7FJ-
        L---JF-JLJ.||-FJLJJ7
        |F|F-JF---7F7-L7L|7|
        |FFJF7L7F-JF7|JL---7
        7-L-JL7||F7|L7F-7F7|
        L.L7LFJ|||||FJL7||LJ
        L7JLJL-JLJLJL--JLJ.L
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day10(inputPart1).solvePart1()

            assertEquals(8, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()

            assertEquals(6697, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day10(inputPart2).solvePart2()

            assertEquals(10, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()

            assertEquals(423, answer)
        }
    }
}