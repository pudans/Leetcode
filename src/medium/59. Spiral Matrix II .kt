package medium

import ArraysTopic
import MatrixTopic

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */

class Medium59 : ArraysTopic, MatrixTopic {

    enum class Direction { RIGHT, DOWN, LEFT, UP }

    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        var z = 1
        var i = 0
        var j = 0
        var direction = Direction.RIGHT
        val destSize = matrix.size * matrix.first().size
        while (z <= destSize) {
            if (matrix[i][j] == 0) {
                matrix[i][j] = z
                z++
            }
            var newi = i
            var newj = j
            when (direction) {
                Direction.RIGHT -> newj++
                Direction.DOWN -> newi++
                Direction.LEFT -> newj--
                Direction.UP -> newi--
            }

            val isNeedChangeDirect = when {
                newi >= matrix.size -> true
                newi < 0 -> true
                newj >= matrix[0].size -> true
                newj < 0 -> true
                matrix[newi][newj] != 0 -> true
                else -> false
            }

            if (isNeedChangeDirect) {
                direction = Direction.values()[(direction.ordinal + 1) % Direction.values().size]
            } else {
                i = newi
                j = newj
            }
        }
        return matrix
    }
}

fun main() {
    println(Medium59().generateMatrix(1).map { it.toList() }.map { it.toList() })
    println(Medium59().generateMatrix(2).map { it.toList() }.map { it.toList() })
    println(Medium59().generateMatrix(3).map { it.toList() }.map { it.toList() })
    println(Medium59().generateMatrix(4).map { it.toList() }.map { it.toList() })
}