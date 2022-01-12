package medium

import BFSTopic
import DynamicProgrammingTopic
import MatrixTopic

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 *
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
 */

class Medium542 : MatrixTopic, BFSTopic, DynamicProgrammingTopic {

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix.size) { IntArray(matrix.first().size) { Int.MAX_VALUE - 10000 } }
        for (i in matrix.indices) {
            for (j in matrix.first().indices) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0
                    continue
                }
                if (i > 0) result[i][j] = minOf(result[i][j], result[i - 1][j] + 1)
                if (j > 0) result[i][j] = minOf(result[i][j], result[i][j - 1] + 1)
            }
        }
        for (i in matrix.lastIndex downTo 0) {
            for (j in matrix.first().lastIndex downTo 0) {
                if (i < matrix.lastIndex) result[i][j] = minOf(result[i][j], result[i + 1][j] + 1)
                if (j < matrix.first().lastIndex) result[i][j] = minOf(result[i][j], result[i][j + 1] + 1)
            }
        }
        return result
    }
}

fun main() {
    println(Medium542().updateMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
    println(Medium542().updateMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1))))
}