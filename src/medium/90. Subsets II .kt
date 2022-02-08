package medium

import ArraysTopic
import BacktrackingTopic
import BitManipulationTopic

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 *
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 * BULLSHIT
 */

class Medium90 : ArraysTopic, BacktrackingTopic, BitManipulationTopic {

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = HashSet<List<Int>>()
        val n = Math.pow(2.0, nums.size.toDouble()).toInt()
        for (i in 0 until n) {
            val str = Integer.toBinaryString(i)
            val res = ArrayList<Int>()
            for (j in nums.indices) {
                if (nums.size - j <= str.length && str[j - (nums.size - str.length)] == '1') {
                    res.add(nums[j])
                }
            }
            result.add(res.sorted())
        }
        return result.toList()
    }
}

fun main() {
    println(Medium90().subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)))
    println(Medium90().subsetsWithDup(intArrayOf(1, 2, 2)))
    println(Medium90().subsetsWithDup(intArrayOf(1, 2, 3)))
    println(Medium90().subsetsWithDup(intArrayOf(0)))
}