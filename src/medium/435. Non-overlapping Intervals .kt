package medium

import DynamicProgrammingTopic
import GreedyTopic
import SortingTopic
import java.util.*


/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */

class Medium435 : DynamicProgrammingTopic, GreedyTopic, SortingTopic {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val arr = Array(intervals.size) { intArrayOf(intervals[it][0], intervals[it][1]) }
        arr.sortBy { it[1] }
        val list = mutableListOf<IntArray>()
        list.add(intArrayOf(arr[0][0], arr[0][1]))
        var prev = 0
        for (curr in arr.indices) {
            if (arr[curr][0] >= arr[prev][1]) {
                list.add(intArrayOf(arr[curr][0], arr[curr][1]))
                prev = curr
            }
        }
        return arr.size - list.size
    }
}

fun main() {
    println(
        Medium435().eraseOverlapIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 3)
            )
        )
    )
    println(
        Medium435().eraseOverlapIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 2),
                intArrayOf(1, 2),
            )
        )
    )
    println(
        Medium435().eraseOverlapIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
            )
        )
    )
}