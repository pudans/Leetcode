package easy

import ArraysTopic
import DynamicProgrammingTopic

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */

class Easy53: ArraysTopic, DynamicProgrammingTopic {

    fun maxSubArray(nums: IntArray): Int {
        var soFar = Int.MIN_VALUE
        var currMax = 0
        nums.forEach {
            if (currMax < 0) {
                currMax = 0
            }
            soFar = Math.max(soFar, currMax + it)
            currMax += it
        }
        return soFar
    }
}

fun main() {
    println(Easy53().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(Easy53().maxSubArray(intArrayOf(1)))
    println(Easy53().maxSubArray(intArrayOf(5,4,-1,7,8)))
}