package medium

import ArraysTopic
import MatrixTopic

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */

class Medium54: ArraysTopic, MatrixTopic {

    enum class Direction {
        RIGHT, DOWN, LEFT, UP
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return listOf()
        val result = ArrayList<Int>()
        val visited = HashSet<Pair<Int, Int>>()
        var i = 0
        var j = 0
        var direction = Direction.RIGHT
        val destSize = matrix.size * matrix[0].size
        while (result.size < destSize) {
            if (!visited.contains(Pair(i, j))) {
                result.add(matrix[i][j])
                visited.add(Pair(i, j))
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
                visited.contains(Pair(newi, newj)) -> true
                else -> false
            }

            if (isNeedChangeDirect) {
                direction = changeDirection(direction)
            } else {
                i = newi
                j = newj
            }
        }
        return result
    }

    private fun changeDirection(direction: Direction): Direction =
        when (direction) {
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
            Direction.UP -> Direction.RIGHT
        }
}