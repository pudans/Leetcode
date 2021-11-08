package medium

import ArraysTopic
import BacktrackingTopic
import BitManipulationTopic

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class Medium78: ArraysTopic, BacktrackingTopic, BitManipulationTopic {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val n = Math.pow(2.0, nums.size.toDouble()).toInt()
        for (i in 0 until n) {
            val str = Integer.toBinaryString(i)
            val res = ArrayList<Int>()
            for (j in nums.indices) {
                if (nums.size - j > str.length && str[j - (nums.size - str.length)] == '1') {
                    res.add(nums[j])
                }
            }
            result.add(res)
        }
        return result
    }
}

fun main() {
    println(Medium78().subsets(intArrayOf(1,2,3)))
    println(Medium78().subsets(intArrayOf(0)))
}