package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
class Day12Test {
    private val input = """
        ???.### 1,1,3
        .??..??...?##. 1,1,3
        ?#?#?#?#?#?#?#? 1,3,1,6
        ????.#...#... 4,1,1
        ????.######..#####. 1,6,5
        ?###???????? 3,2,1
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart1()

            assertEquals(21, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart1()

            assertEquals(6871, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart2()

            assertEquals(525_152, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart2()

            assertEquals(2_043_098_029_844, answer)
        }
    }
}