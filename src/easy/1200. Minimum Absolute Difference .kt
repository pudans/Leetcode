package easy

import ArraysTopic
import SortingTopic

/**
 * 1200. Minimum Absolute Difference
 * https://leetcode.com/problems/minimum-absolute-difference/
 *
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 */

class Easy1200 : ArraysTopic, SortingTopic {

    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var min = Int.MAX_VALUE
        arr.sort()
        for (i in 1 until arr.size) {
            val d = arr[i] - arr[i-1]
            if (d < min) {
                min = d
                result.clear()
            }
            if (d == min) {
                result.add(listOf(arr[i-1], arr[i]))
            }
        }
        return result
    }
}

fun main() {
    println(Easy1200().minimumAbsDifference(intArrayOf(4, 2, 1, 3)))
    println(Easy1200().minimumAbsDifference(intArrayOf(1, 3, 6, 10, 15)))
    println(Easy1200().minimumAbsDifference(intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)))
}