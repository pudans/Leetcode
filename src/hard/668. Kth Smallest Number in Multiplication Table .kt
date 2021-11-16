package hard

import BinarySearchTopic
import java.util.*


/**
 * 668. Kth Smallest Number in Multiplication Table
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 *
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
 */

class Hard668: BinarySearchTopic {

    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        var start = 1
        var end = m * n
        while (start <= end) {
            val mid = start + (end - start) / 2
            val ans = (1..m).sumBy { (mid / it).coerceAtMost(n) }
            if (ans < k) { // check count
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return start
    }

    fun findKthNumber1(m: Int, n: Int, k: Int): Int {
        val matrix = Array(m) { IntArray(n) }
        val queue = PriorityQueue<Int>()
        for (i in matrix.indices) {
            for (j in matrix.first().indices) {
                matrix[i][j] = when {
                    i == 0 -> j + 1
                    j == 0 -> i + 1
                    else -> matrix[i][0] * matrix[0][j]
                }
                queue.offer(matrix[i][j])
            }
        }
        repeat(k - 1) {
            queue.poll()
        }
        return queue.poll()
    }
}

fun main() {
    println(Hard668().findKthNumber(3,3,5))
    println(Hard668().findKthNumber(2,3,6))
}