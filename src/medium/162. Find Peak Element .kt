package medium

import ArraysTopic
import BinarySearchTopic


/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 */

class Medium162 : ArraysTopic, BinarySearchTopic {

    fun findPeakElement(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex
        while (start < end) {
            val mid = (start + end) / 2
            if (nums[mid] > nums[mid + 1]) end = mid else start = mid + 1
        }
        return start
    }

    // mine
    fun findPeakElement1(nums: IntArray): Int {
        for (i in 0 until nums.lastIndex) {
            if (nums[i] > nums[i + 1]) return i
        }
        return nums.lastIndex
    }
}

fun main() {
    println(Medium162().findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(Medium162().findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
}