package medium

import ArraysTopic
import MathTopic
import MatrixTopic

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */

class Medium48 : ArraysTopic, MathTopic, MatrixTopic {

    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (j in 0 until n / 2) {
            for (i in j until n - 1 - j) {
                val tmp = matrix[i][n - 1 - j]
                matrix[i][n - 1 - j] = matrix[j][i]
                matrix[j][i] = matrix[n - 1 - i][j]
                matrix[n - 1 - i][j] = matrix[n - 1 - j][n - 1 - i]
                matrix[n - 1 - j][n - 1 - i] = tmp
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    Medium48().rotate(matrix)
    println(matrix.map { it.toList() }.map { it.toList() })
}