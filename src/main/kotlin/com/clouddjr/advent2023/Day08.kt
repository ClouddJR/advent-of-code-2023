package com.clouddjr.advent2023

import com.clouddjr.advent2023.utils.lcm

class Day08(input: List<String>) {
    private val dirs = input.first.map { if (it == 'L') 0 else 1 }

    private val nodes = input.drop(2).associate {
        it.substringBefore(" =") to it.substringAfter("(").substringBefore(")").split(", ")
    }

    fun solvePart1(): Long {
        return steps(node = "AAA", repeat = { it != "ZZZ" })
    }

    fun solvePart2(): Long {
        val beginning = nodes.keys.filter { it.last() == 'A' }
        val steps = beginning.map { node -> steps(node = node, repeat = { it.last() != 'Z' }) }

        return steps.lcm()
    }

    private fun steps(node: String, repeat: (node: String) -> Boolean): Long {
        var steps = 0L

        var current = node
        while (repeat(current)) {
            current = nodes[current]!![dirs[(steps++ % dirs.size).toInt()]]
        }

        return steps
    }
}