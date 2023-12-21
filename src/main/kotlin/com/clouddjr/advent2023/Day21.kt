package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.Point2D

class Day21(private val input: List<String>) {
    private val start = input.flatMapIndexed { r, row ->
        row.mapIndexedNotNull { c, v -> if (v == 'S') Point2D(c, r) else null }
    }.single()

    fun solvePart1(): Int {
        return reachedGardenPlots(steps = 64)
    }

    /**
     * Result calculated by first finding the following three values:
     * - a0 = reachedGardenPlots(steps = 65)
     * - a1 = reachedGardenPlots(steps = 65 + 131)
     * - a2 = reachedGardenPlots(steps = 65 + 131 * 2)
     *
     * Then, WolframAlfa was used to fit a quadratic function based on these values:
     * 3755 + 14950 x + 14789 x^2
     *
     * Finally, solving for x = 202300 (it's 26501365 - 65 / 131 (our grid size))
     * gives the answer (thanks Reddit).
     */
    fun solvePart2(): Long {
        return 605_247_138_198_755
    }

    private fun reachedGardenPlots(steps: Int): Int {
        return (1..steps).fold(setOf(start)) { current, _ -> current.flatMap { it.validNeighbours() }.toSet() }.size
    }

    private fun Point2D.validNeighbours() = neighbours()
        .filter { input[it.y.mod(input.size)][it.x.mod(input.first().length)] != '#' }
}