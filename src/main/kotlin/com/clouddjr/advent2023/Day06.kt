package com.clouddjr.advent2023

class Day06(input: List<String>) {
    private val times = input.first.split("\\s+".toRegex()).drop(1).map { it.toLong() }
    private val dists = input.last.split("\\s+".toRegex()).drop(1).map { it.toLong() }

    fun solvePart1(): Int {
        return times.zip(dists).map { (time, dist) -> countWays(time, dist) }.reduce { acc, i -> acc * i }
    }

    fun solvePart2(): Int {
        val time = times.joinToString("").toLong()
        val dist = dists.joinToString("").toLong()
        return countWays(time, dist)
    }

    private fun countWays(time: Long, dist: Long): Int {
        return (1..time).count { remaining -> remaining * (time - remaining) > dist }
    }
}