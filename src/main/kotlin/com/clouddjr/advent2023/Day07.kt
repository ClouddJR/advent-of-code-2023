package com.clouddjr.advent2023

class Day07(private val input: List<String>) {
    fun solvePart1(): Int {
        return input.map { Hand.from(it, hasJokers = false) }.totalWinnings()
    }

    fun solvePart2(): Int {
        Hand.order['J'] = -1
        return input.map { Hand.from(it, hasJokers = true) }.totalWinnings()
    }

    private fun List<Hand>.totalWinnings() = sorted().withIndex().sumOf { (i, hand) -> (i + 1) * hand.bid }

    private data class Hand(val hand: String, val bid: Int, val hasJokers: Boolean) : Comparable<Hand> {
        private val counter: List<Int>

        init {
            val map = hand.groupingBy { it }.eachCount().toMutableMap()
            if (hasJokers) {
                val jokers = map.getOrDefault('J', 0)
                if (jokers in 1..4) {
                    val max = map.entries.filterNot { it.key == 'J' }.sortedByDescending { it.value }.first.key
                    map.remove('J')
                    map[max] = map[max]!! + jokers
                }
            }
            counter = map.values.sortedDescending()
        }

        override fun compareTo(other: Hand): Int {
            return Comparator<Hand> { h1, h2 ->
                val i = h1.counter.indices.firstOrNull { i -> h1.counter[i] != h2.counter[i] }
                if (i == null) 0 else h1.counter[i] - h2.counter[i]
            }.then { h1, h2 ->
                val i = h1.hand.indices.firstOrNull { i -> h1.hand[i] != h2.hand[i] }
                if (i == null) 0 else order[(h1.hand[i])]!! - order[(h2.hand[i])]!!
            }.compare(this, other)
        }

        companion object {
            val order = "23456789TJQKA".withIndex().associate { it.value to it.index }.toMutableMap()

            fun from(line: String, hasJokers: Boolean): Hand {
                return Hand(
                    hand = line.substringBefore(" "),
                    bid = line.substringAfter(" ").toInt(),
                    hasJokers = hasJokers
                )
            }
        }
    }
}