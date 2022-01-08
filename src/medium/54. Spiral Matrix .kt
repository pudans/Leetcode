package medium

import ArraysTopic
import MatrixTopic

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */

class Medium54 : ArraysTopic, MatrixTopic {

    enum class Direction { RIGHT, DOWN, LEFT, UP }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return listOf()
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        var direction = Direction.RIGHT
        val destSize = matrix.size * matrix.first().size
        while (result.size < destSize) {
            if (matrix[i][j] != -200) {
                result.add(matrix[i][j])
                matrix[i][j] = -200
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
                matrix[newi][newj] == -200 -> true
                else -> false
            }

            if (isNeedChangeDirect) {
                direction = Direction.values()[(direction.ordinal + 1) % Direction.values().size]
            } else {
                i = newi
                j = newj
            }
        }
        return result
    }
}