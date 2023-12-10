package com.clouddjr.advent2023.utils

data class Point2D(val x: Int, val y: Int) {
    fun neighbours(): List<Point2D> {
        return listOf(
            Point2D(x - 1, y),
            Point2D(x + 1, y),
            Point2D(x, y - 1),
            Point2D(x, y + 1),
        )
    }
}