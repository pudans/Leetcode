package medium

class Solution73 {

    fun setZeroes(matrix: Array<IntArray>): Unit {
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