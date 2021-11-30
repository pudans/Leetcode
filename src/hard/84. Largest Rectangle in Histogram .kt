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

//    fun largestRectangleArea(heights: IntArray): Int {
//        val set = heights.toHashSet()
//        var result = 0
//        set.forEach { i ->
//            var currMaxLen = 0
//            heights.forEach {
//                if (it < i) {
//                    result = Math.max(result, currMaxLen * i)
//                    currMaxLen = 0
//                }
//                else currMaxLen++
//            }
//            if (currMaxLen > 0) {
//                result = Math.max(result, currMaxLen * i)
//            }
//        }
//        return result
//    }

    fun largestRectangleArea(heights: IntArray): Int {
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
    println(Hard84().largestRectangleArea(intArrayOf(2,1,5,6,2,3)))
    println(Hard84().largestRectangleArea(intArrayOf(2,4)))
}