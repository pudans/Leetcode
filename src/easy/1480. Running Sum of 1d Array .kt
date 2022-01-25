package easy

import ArraysTopic
import java.util.*

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 *
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.
 */

class Easy1480 : ArraysTopic {

    fun runningSum(nums: IntArray): IntArray =
        nums.also { for (i in 1 until nums.size) nums[i] += nums[i - 1] }
}

fun main() {
    println(Easy1480().runningSum(intArrayOf(1, 2, 3, 4)).toList())
    println(Easy1480().runningSum(intArrayOf(1, 1, 1, 1, 1)).toList())
    println(Easy1480().runningSum(intArrayOf(3, 1, 2, 10, 1)).toList())
}