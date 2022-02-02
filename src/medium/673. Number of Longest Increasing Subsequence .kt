package medium

import DynamicProgrammingTopic

/**
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

BULLSHIT
 */

class Medium673 : DynamicProgrammingTopic {

    fun findNumberOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dpLen = IntArray(n)
        val dpCnt = IntArray(n)
        var maxLen = 1
        var total = 0
        for (i in 0 until n) {
            dpLen[i] = 1
            dpCnt[i] = 1
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    // Take the dpLen[j] subsequence length and increment by 1
                    // and copy the dpCnt[j] to dpCnt[i] as the number of ways to reach j and i will be the same
                    if (dpLen[i] < dpLen[j] + 1) {
                        dpLen[i] = dpLen[j] + 1
                        dpCnt[i] = dpCnt[j]
                    } else if (dpLen[i] == dpLen[j] + 1) {
                        dpCnt[i] += dpCnt[j]
                    }
                }
            }
            // When more than one way we can reach the maxLen, then we add dpCnt[i] to the total ways
            if (maxLen == dpLen[i]) total += dpCnt[i]
            // When dpLen[i] is bigger than maxLen, then we reset maxLen and total
            if (maxLen < dpLen[i]) {
                maxLen = dpLen[i]
                total = dpCnt[i]
            }
        }
        return total
    }
}

fun main() {
    println(Medium673().findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7)))
    println(Medium673().findNumberOfLIS(intArrayOf(2, 2, 2, 2, 2)))

}