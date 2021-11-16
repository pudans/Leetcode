package medium

import DynamicProgrammingTopic
import SortingTopic
import java.util.*


/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/
 *
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j])
of elements in this subset satisfies:
answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 BULLSIHT
 */

class Medium368 : SortingTopic, DynamicProgrammingTopic {

    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        var max = 0
        var prev = 0
        var idx = 0
        val dp = IntArray(nums.size)
        for (i in nums.indices) {
            dp[i] = 1
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0 && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1
                }
            }
            if (dp[i] > max) {
                max = dp[i]
                prev = nums[i]
                idx = i
            }
        }
        val result = ArrayList<Int>()
        for (i in idx downTo 0) {
            if (max == 0) break
            if (dp[i] == max && prev % nums[i] == 0) {
                result.add(nums[i])
                prev = nums[i]
                max--
            }
        }
        return result
    }
}

fun main() {
    println(Medium368().largestDivisibleSubset(intArrayOf(1, 2, 3)))
    println(Medium368().largestDivisibleSubset(intArrayOf(1, 2, 4, 8)))
    println(Medium368().largestDivisibleSubset(intArrayOf(2, 4)))
    println(Medium368().largestDivisibleSubset(intArrayOf(3,4,16,8)))
    println(Medium368().largestDivisibleSubset(intArrayOf(1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824)))
}