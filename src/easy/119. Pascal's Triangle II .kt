package easy

import DynamicProgrammingTopic

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

class Easy119 : DynamicProgrammingTopic {

    fun getRow(rowIndex: Int): List<Int> {
        var lastRow: IntArray = intArrayOf(1)
        for (i in 1..rowIndex) {
            val inner = IntArray(i + 1)
            inner[0] = 1
            inner[i] = 1
            for (j in 1..(i / 2)) {
                val t = lastRow[j - 1] + lastRow[j]
                inner[j] = t
                inner[i - j] = t
            }
            lastRow = inner
        }
        return lastRow.toList()
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