package com.clouddjr.advent2023

import com.clouddjr.advent2023.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 19")
class Day19Test {
    private val input = """
        px{a<2006:qkq,m>2090:A,rfg}
        pv{a>1716:R,A}
        lnx{m>1548:A,A}
        rfg{s<537:gd,x>2440:R,A}
        qs{s>3448:A,lnx}
        qkq{x<1416:A,crn}
        crn{x>2662:A,R}
        in{s<1351:px,qqz}
        qqz{s>2770:qs,m<1801:hdj,R}
        gd{a>3333:R,R}
        hdj{m>838:A,pv}

        {x=787,m=2655,a=1222,s=2876}
        {x=1679,m=44,a=2067,s=496}
        {x=2036,m=264,a=79,s=2244}
        {x=2461,m=1339,a=466,s=291}
        {x=2127,m=1623,a=2188,s=1013}
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day19(input).solvePart1()

            assertEquals(19_114, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsText("day19.txt")).solvePart1()

            assertEquals(353_553, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day19(input).solvePart2()

            assertEquals(167_409_079_868_000, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsText("day19.txt")).solvePart2()
            assertEquals(124_615_747_767_410, answer)
        }
    }
}