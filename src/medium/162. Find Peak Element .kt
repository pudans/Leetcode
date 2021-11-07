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
        for (i in nums.indices) {
            val prev = if (i == 0) true else nums[i] > nums[i-1]
            val next = if (i == nums.size - 1) true else nums[i] > nums[i+1]

            if (prev && next) {
                return i
            }
        }
        return -1
    }
}