package com.clouddjr.advent2023

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

    private fun List<Long>.lcm() = reduce { a, b -> lcm(a, b) }

    private fun lcm(a: Long, b: Long): Long = (a * b) / gcd(a, b)

    private fun gcd(a: Long, b: Long): Long = if (a == 0L) b else gcd(b % a, a)
}