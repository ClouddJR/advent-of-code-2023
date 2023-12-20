package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 20")
class Day20Test {
    private val input = """
        broadcaster -> a
        %a -> inv, con
        &inv -> b
        %b -> con
        &con -> output
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day20(input).solvePart1()

            assertEquals(11_687_500, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart1()

            assertEquals(1_020_211_150, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart2()

            assertEquals(238_815_727_638_557, answer)
        }
    }
}