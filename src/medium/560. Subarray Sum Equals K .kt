package medium

import ArraysTopic

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 */

class Medium560 : ArraysTopic {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in nums.indices) {
            var sum = 0
            for (j in i until nums.size) {
                sum += nums[j]
                if (sum == k) result++
            }
        }
        return result
    }
}

fun main() {
    println(Medium560().subarraySum(intArrayOf(1, 1, 1), 2))
    println(Medium560().subarraySum(intArrayOf(1, 2, 3), 3))
    println(Medium560().subarraySum(intArrayOf(1, -1, 0), 0))
}