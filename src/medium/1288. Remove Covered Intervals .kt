package medium

import ArraysTopic
import SortingTopic
import java.util.*


/**
 * 1288. Remove Covered Intervals
 * https://leetcode.com/problems/remove-covered-intervals/
 *
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
Return the number of remaining intervals.

BULLSHIT
 */

class Medium1288 : ArraysTopic, SortingTopic {

    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        Arrays.sort(intervals) { a, b -> if (a[0] == b[0]) b[1] - a[1] else a[0] - b[0] }
        var count = 0
        var cur = 0
        for (interval in intervals) {
            if (cur < interval[1]) {
                cur = interval[1]
                count++
            }
        }
        return count
    }
}

fun main() {
    println(Medium1288().removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))))
    println(Medium1288().removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
}