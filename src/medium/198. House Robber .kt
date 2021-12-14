package medium

import ArraysTopic
import DynamicProgrammingTopic
import kotlin.math.max

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */

class Medium198 : ArraysTopic, DynamicProgrammingTopic {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }
        return dp.last()
    }
}

fun main() {
    println(Medium198().rob(intArrayOf(1,2,3,1)))
    println(Medium198().rob(intArrayOf(2,7,9,3,1)))
    println(Medium198().rob(intArrayOf(121,48,151,122,147,24,30,61,41,200,244,194,201,147,195,170,80,41,229,46,69,231,40,74,241,151,224,96,132,108,41,244,224,44,14,147,32,5,27,231,77,60,233,31,169,17,169,28,129,157,3,73,139,3,132,133,34,154,101,84,13,134,124,172,239,202,147,8,213,178,193,70,14,212,0,203,237,202,80,140,250,150,144,224)))
}