package medium

import ArraysTopic
import DynamicProgrammingTopic

/**
 * 413. Arithmetic Slices
 * https://leetcode.com/problems/count-and-say/
 *
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array.

 BULLSHIT
 */

class Medium413 : ArraysTopic, DynamicProgrammingTopic {

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var count = 0
        for (i in 0 until nums.size - 2) {
            val diff = nums[i + 1] - nums[i]
            for (j in i + 2 until nums.size) {
                if (nums[j] - nums[j - 1] == diff) {
                    count++
                } else {
                    break
                }
            }
        }
        return count
    }
}

fun main() {
    println(Medium413().numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)))
    println(Medium413().numberOfArithmeticSlices(intArrayOf(1)))
}