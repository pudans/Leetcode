package medium

import DynamicProgrammingTopic
import java.util.*


/**
 * 740. Delete and Earn
 * https://leetcode.com/problems/delete-and-earn/
 *
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

BULLSHIT
 */

class Medium740 : DynamicProgrammingTopic {

    fun deleteAndEarn(nums: IntArray): Int {
        val arr = IntArray(10001)
        for (i in nums.indices) {
            arr[nums[i]]++
        }
        var inc = 0
        var exc = 0
        for (i in arr.indices) {
            val nexc = maxOf(inc, exc)
            inc = exc + i * arr[i]
            exc = nexc
        }
        return maxOf(inc, exc)
    }
}

fun main() {
    println(Medium740().deleteAndEarn(intArrayOf(3, 4, 2)))
    println(Medium740().deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
    println(Medium740().deleteAndEarn(intArrayOf(3, 1)))
}