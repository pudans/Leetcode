package medium

import GreedyTopic

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 */

class Medium334 : GreedyTopic {

    fun increasingTriplet(nums: IntArray): Boolean {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (num in nums) {
            when {
                num <= first -> first = num
                num <= second -> second = num
                else -> return true
            }
        }
        return false
    }

    // Mine
    fun increasingTriplet2(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }

        for (i in 0 until nums.size - 2) {
            for (j in i until nums.size - 1) {
                for (z in j until nums.size) {
                    if (nums[i] < nums[j] && nums[j] < nums[z]) {
                        return true
                    }
                }
            }
        }
        return false
    }
}