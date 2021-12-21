package easy

import ArraysTopic
import MatrixTopic

/**
 * 566. Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/
 *
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */

class Easy566 : ArraysTopic, MatrixTopic {

    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val oldR = mat.size
        val oldC = mat.first().size
        if (oldR * oldC != r * c) return mat
        val result = Array(r) { IntArray(c) }
        for (i in 0 until oldC * oldR) {
            result[i / c][i % c] = mat[i / oldC][i % oldC]
        }
        return result
    }
}

fun main() {
    val input = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
    val result = Easy566().matrixReshape(input, 1, 6)
    result.forEach { println(it.toList()) }
}