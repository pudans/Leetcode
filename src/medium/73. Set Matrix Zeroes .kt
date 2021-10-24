package medium

import ArraysTopic
import HashTableTopic
import MatrixTopic

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * You must do it in place.
 */

class Medium73: ArraysTopic, HashTableTopic, MatrixTopic {

    fun setZeroes(matrix: Array<IntArray>) {
        val hash = HashSet<Int>()
        for (i in matrix.indices) {
            for (j in matrix.indices) {
                if (matrix[i][j] == 0) {
                    hash.add(i+1)
                    hash.add(-j-1)
                }
            }
        }
        println(hash.toString())
        hash.forEach {
            if (it < 0) {
                for (i in matrix.indices) {
                    matrix[i][it-1] = 0
                }
            } else {
                for (i in matrix[0].indices) {
                    matrix[-it+1][i] = 0
                }
            }
        }
    }
}