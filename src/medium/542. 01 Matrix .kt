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

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val min = Array(mat.size) { IntArray(mat.first().size) { Int.MAX_VALUE - 10000 } }

        for (i in mat.indices) {
            for (j in mat.first().indices) {
                if (mat[i][j] == 0) {
                    min[i][j] = 0
                    continue
                }
                if (i > 0) min[i][j] = minOf(min[i][j], min[i-1][j] + 1)
                if (j > 0) min[i][j] = minOf(min[i][j], min[i][j-1] + 1)
            }
        }
        for (i in mat.lastIndex downTo 0) {
            for (j in mat.first().lastIndex downTo 0) {
                if (i < mat.lastIndex) min[i][j] = minOf(min[i][j], min[i+1][j] + 1)
                if (j < mat.first().lastIndex) min[i][j] = minOf(min[i][j], min[i][j+1] + 1)
            }
        }

        println(min.map { it.toList() }.map { it.toList() })

        return min
    }
}

fun main() {
    println(Medium542().updateMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
    println(Medium542().updateMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1))))
}