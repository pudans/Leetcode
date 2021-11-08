package medium

import HashTableTopic

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 */

class Medium560 : HashTableTopic {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in nums.indices) {
            var dd = 0
            for (j in i until nums.size) {
                dd += nums[j]
                if (dd == k) {
                    result++
                }
            }
        }
        return result
    }
}

fun main() {
    println(Medium560().subarraySum(intArrayOf(1,2,3), 3))
}