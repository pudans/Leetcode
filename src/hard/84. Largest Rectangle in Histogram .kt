package hard

import ArraysTopic
import StackTopic
import java.util.*

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */

class Hard84 : ArraysTopic, StackTopic {

    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>()
        var max = 0
        stack.push(-1)
        for (i in 0..heights.size) {
            val value = heights.getOrNull(i) ?: 0
            while (stack.peek() >= 0 && heights[stack.peek()] >= value) {
                val height = heights[stack.pop()]
                val start = stack.peek()
                max = maxOf(max, height * (i - start - 1))
            }
            stack.push(i)
        }
        return max
    }
}

fun main() {
    println(Hard84().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    println(Hard84().largestRectangleArea(intArrayOf(2, 4)))
}