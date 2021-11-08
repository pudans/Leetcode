package medium

import GreedyTopic
import SortingTopic
import TwoPointersTopic

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.
 */

class Medium581 : TwoPointersTopic, GreedyTopic, SortingTopic {

    fun findUnsortedSubarray(nums: IntArray): Int {
        val cloned = nums.clone().sortedArray()
        var start = cloned.size
        var end = 0
        for (i in cloned.indices) {
            if (cloned[i] != nums[i]) {
                start = Math.min(start, i)
                end = Math.max(end, i)
            }
        }
        return if (end - start >= 0) end - start + 1 else 0
    }
}

fun main() {
    println(Medium581().findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)))
}