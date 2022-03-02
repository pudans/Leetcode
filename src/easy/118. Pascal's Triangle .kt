package easy

import ArraysTopic
import DynamicProgrammingTopic

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 */

class Easy118 : ArraysTopic, DynamicProgrammingTopic {

    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) return emptyList()
        val result = ArrayList<List<Int>>(numRows)
        result.add(listOf(1))
        for (i in 1 until numRows) {
            val row = IntArray(i + 1)
            row[0] = 1
            row[i] = 1
            for (j in 1..(i / 2)) {
                val t = result[i - 1][j - 1] + result[i - 1][j]
                row[j] = t
                row[i - j] = t
            }
            result.add(i, row.toList())
        }
        return result
    }
}

fun main() {
    println(Easy118().generate(0))
    println(Easy118().generate(1))
    println(Easy118().generate(2))
    println(Easy118().generate(3))
    println(Easy118().generate(4))
    println(Easy118().generate(5))
}