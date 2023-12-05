package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
class Day05Test {
    private val input = """
        seeds: 79 14 55 13

        seed-to-soil map:
        50 98 2
        52 50 48

        soil-to-fertilizer map:
        0 15 37
        37 52 2
        39 0 15

        fertilizer-to-water map:
        49 53 8
        0 11 42
        42 0 7
        57 7 4

        water-to-light map:
        88 18 7
        18 25 70

        light-to-temperature map:
        45 77 23
        81 45 19
        68 64 13

        temperature-to-humidity map:
        0 69 1
        1 0 69

        humidity-to-location map:
        60 56 37
        56 93 4
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart1()

            assertEquals(35, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart1()

            assertEquals(88_151_870, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart2()

            assertEquals(46, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart2()

            assertEquals(2_008_785, answer)
        }
    }
}