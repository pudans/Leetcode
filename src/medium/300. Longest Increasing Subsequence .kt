package medium

import DynamicProgrammingTopic

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */

class Medium300 : DynamicProgrammingTopic {

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var result = 1
        val dp = IntArray(nums.size)
        dp[0] = 1
        for (i in 1 until nums.size) {
            var max = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j] && dp[j] > max)
                    max = dp[j]
            }
            dp[i] = max + 1
            result = maxOf(result, dp[i])
        }
        return result
    }
}

fun main() {
    println(Medium300().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    println(Medium300().lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
    println(Medium300().lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
}