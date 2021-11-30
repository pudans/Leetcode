package hard

import ArraysTopic
import DynamicProgrammingTopic
import MatrixTopic
import java.util.*


/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */

class Hard85 : ArraysTopic, DynamicProgrammingTopic, MatrixTopic {

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0
        val heights = IntArray(matrix.first().size)
        var result = 0
        for (element in matrix) {
            for (j in heights.indices) {
                heights[j] = when(element[j] == '1') {
                    true -> heights[j] + 1
                    false -> 0
                }
            }
            result = Math.max(result, largestRectangleArea(heights))
        }
        return result
    }

    private fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>()
        var max = 0
        stack.push(-1)
        for (i in 0..heights.size) {
            val value = heights.getOrElse(i) { 0 }
            while (stack.peek() >= 0 && heights[stack.peek()] >= value) {
                val height = heights[stack.pop()]
                val start = stack.peek()
                max = Math.max(max, height * (i - start - 1))
            }
            stack.push(i)
        }
        return max
    }
}

fun main() {
    val dd = Hard85().maximalRectangle(
            arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
            )
    )
    println(dd)
}