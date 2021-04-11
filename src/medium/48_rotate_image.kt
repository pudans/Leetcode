package medium

class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        for (j in 0 until n / 2) {
            for (i in j until n-1-j) {
                val tmp = matrix[i][n-1-j]
                matrix[i][n-1-j] = matrix[j][i]
                matrix[j][i] = matrix[n-1-i][j]
                matrix[n-1-i][j] = matrix[n-1-j][n-1-i]
                matrix[n-1-j][n-1-i] = tmp
            }
        }
    }
}