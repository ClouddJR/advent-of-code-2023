package com.clouddjr.advent2023

class Day15(input: String) {
    private val steps = input.split(",")

    fun solvePart1(): Int {
        return steps.sumOf { it.hash() }
    }

    fun solvePart2(): Int {
        val boxes = List(256) { mutableMapOf<String, Lens>() }

        steps.forEach { step ->
            when {
                "-" in step -> {
                    val label = step.substringBefore("-")
                    boxes[label.hash()].remove(label)
                }

                "=" in step -> {
                    val label = step.substringBefore("=")
                    val length = step.substringAfter("=").toInt()
                    boxes[label.hash()][label] = Lens(label, length)
                }
            }
        }

        return boxes.withIndex().sumOf { (i, box) ->
            box.values.withIndex().sumOf { (j, lens) -> (i + 1) * (j + 1) * lens.focalLength }
        }
    }

    private fun String.hash(): Int = this.fold(0) { acc, c -> (acc + c.code) * 17 % 256 }

    private data class Lens(val label: String, val focalLength: Int)
}