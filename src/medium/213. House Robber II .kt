package medium

import ArraysTopic
import DynamicProgrammingTopic

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 *
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

class Medium213 : ArraysTopic, DynamicProgrammingTopic {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])

        val dp1 = IntArray(nums.size)
        dp1[0] = nums[0]
        dp1[1] = nums[0]
        val dp2 = IntArray(nums.size)
        dp2[1] = nums[1]

        for (i in 2 until nums.size) {
            if (i == nums.lastIndex) dp1[i] = dp1[i - 1]
            else dp1[i] = maxOf(dp1[i - 1], dp1[i - 2] + nums[i])
            dp2[i] = maxOf(nums[i] + dp2[i - 2], dp2[i - 1])
        }
        return maxOf(dp1.last(), dp2.last())
    }
}

fun main() {
    println(Medium213().rob(intArrayOf(2,3,2)))
    println(Medium213().rob(intArrayOf(1,2,3,1)))
    println(Medium213().rob(intArrayOf(1,2,3)))
    println(Medium213().rob(intArrayOf(4,1,2,7,5,3,1)))
}