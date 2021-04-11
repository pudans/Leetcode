package medium

class Solution220 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        for (i in matrix.indices) {
            val col = matrix[i]
            if (col[0] <= target && col[col.size - 1] >= target) {
                val index = col.binarySearch(target)
                println("$index ${col.toList()}")
                if (index >= 0) {
                    return true
                }
            }
        }
        return false
    }
}