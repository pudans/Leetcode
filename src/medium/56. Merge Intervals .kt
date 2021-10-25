package medium

import ArraysTopic
import SortingTopic
import java.util.*

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

class Medium56: ArraysTopic, SortingTopic {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(intArrayOf())
        if (intervals.size == 1) return intervals
        intervals.sortBy { it[0] }
        val stack = Stack<IntArray>()
        stack.add(intervals[0])
        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= stack.peek()[1]) {
                val temp = stack.pop()
                temp[1] = Math.max(temp[1], intervals[i][1])
                stack.push(temp)
            } else {
                stack.push(intervals[i])
            }
        }
        return stack.reversed().toTypedArray()
    }
}

fun main() {
    println(Medium56().merge(arrayOf(intArrayOf(0,1), intArrayOf(1,2))).toList())
    println(Medium56().merge(arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))).toList())
    println(Medium56().merge(arrayOf(intArrayOf(1,4), intArrayOf(4,5))).toList())
}