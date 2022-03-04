package medium

import DynamicProgrammingTopic

/**
 * 799. Champagne Tower
 * https://leetcode.com/problems/champagne-tower/
 *
We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.
Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top.
When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.
When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.
(A glass at the bottom row has its excess champagne fall on the floor.)

For example, after one cup of champagne is poured, the top most glass is full.
After two cups of champagne are poured, the two glasses on the second row are half full.
After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.
After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.

Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 */

class Medium799 : DynamicProgrammingTopic {

    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val result = ArrayList<DoubleArray>(query_row + 1)
        result.add(doubleArrayOf(poured.toDouble()))
        for (i in 1 until query_row + 1) {
            val row = DoubleArray(i + 1)
            for (j in 0 until result[i - 1].size) {
                val score = maxOf(0.0, result[i - 1][j] - 1) / 2
                row[j] += score
                row[j + 1] += score
            }
            result.add(i, row)
        }
        println(result.map { it.toList() })
        return minOf(1.0, result[query_row][query_glass])
    }
}

fun main() {
    println(Medium799().champagneTower(1, 1, 1))
    println(Medium799().champagneTower(2, 1, 1))
    println(Medium799().champagneTower(100000009, 33, 17))
}