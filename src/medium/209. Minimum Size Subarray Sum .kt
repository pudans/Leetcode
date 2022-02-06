package medium

import ArraysTopic
import BinarySearchTopic
import SlidingWindowTopic

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.
 */

class Medium209 : SlidingWindowTopic, BinarySearchTopic, ArraysTopic {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var result = Int.MAX_VALUE
        for (i in nums.indices) {
            var sum = 0
            for (j in i until nums.size) {
                sum += nums[j]
                if (sum >= target) {
                    result = minOf(result, j - i + 1)
                    break
                }
            }
        }
        return if (result == Int.MAX_VALUE) 0 else result
    }
}

fun main() {
    println(Medium209().minSubArrayLen(11, intArrayOf(1,2,3,4,5)))
    println(Medium209().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(Medium209().minSubArrayLen(4, intArrayOf(1, 4, 4)))
    println(Medium209().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))

}