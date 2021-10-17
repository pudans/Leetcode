package easy

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

class Easy119 {

    fun getRow(rowIndex: Int): List<Int> {
        val result = ArrayList<List<Int>>(rowIndex + 1)
        result.add(listOf(1))
        for (i in 1..rowIndex) {
            val inner = arrayOfNulls<Int>(i + 1)
            inner[0] = 1
            inner[i] = 1
            for (j in 1..(i/2)) {
                val t = result[i - 1][j - 1] + result[i - 1][j]
                inner[j] = t
                inner[i - j] = t
            }
            result.add(i, inner.filterNotNull())
        }
        return result[rowIndex]
    }
}

fun main() {
    println(Easy119().getRow(0))
    println(Easy119().getRow(1))
    println(Easy119().getRow(2))
    println(Easy119().getRow(3))
    println(Easy119().getRow(4))
    println(Easy119().getRow(5))
}