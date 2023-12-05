package com.clouddjr.advent2023

class Day05(private val input: String) {
    fun solvePart1(): Long {
        return findMinLocation { seeds -> seeds.map { s -> s to 1 } }
    }

    fun solvePart2(): Long {
        return findMinLocation { seeds -> seeds.chunked(2).map { it.first to it.last } }
    }

    private fun findMinLocation(mapSeedsToRanges: (List<Long>) -> List<Pair<Long, Long>>): Long {
        val groups = input.split("\n\n")
        val seeds = groups.first.split(" ").drop(1).map { it.toLong() }
        val mappings = groups.drop(1).map { g -> g.lines().drop(1).map { l -> l.split(" ").map { it.toLong() } } }

        var ranges = mapSeedsToRanges(seeds)

        for (mapping in mappings) {
            val newRanges = mutableListOf<Pair<Long, Long>>()

            for ((start, len) in ranges) {
                var currStart = start
                var remaining = len

                while (remaining > 0) {
                    var found = false
                    var outside = remaining

                    for ((dst, src, l) in mapping) {
                        if (currStart >= src && currStart < src + l) {
                            val off = currStart - src
                            val rangeLen = minOf(l - off, remaining)
                            newRanges.add(dst + off to rangeLen)
                            remaining -= rangeLen
                            currStart += rangeLen
                            found = true
                            break
                        } else if (currStart < src) {
                            outside = minOf(outside, src - currStart)
                        }
                    }

                    if (!found) {
                        newRanges.add(currStart to outside)
                        remaining -= outside
                        currStart += outside
                    }
                }
            }

            ranges = newRanges
        }

        return ranges.minOf { it.first }
    }
}