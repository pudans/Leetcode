package easy

import ArraysTopic
import HeapTopic

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 *
Given an array of integers nums, you start with an initial positive value startValue.
In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */

class Easy1413: ArraysTopic {

    fun minStartValue(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var result = 0
        nums.forEach { num ->
            result += num
            min = result.coerceAtMost(min)
        }
        return (1 - min).coerceAtLeast(1)
    }
}

fun main() {
    println(Easy1413().minStartValue(intArrayOf(-3,2,-3,4,2)))
    println(Easy1413().minStartValue(intArrayOf(1,2)))
    println(Easy1413().minStartValue(intArrayOf(1,-2,-3)))
}