package medium

import ArraysTopic
import StringTopic
import TwoPointersTopic

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

class Solution15: ArraysTopic, StringTopic, TwoPointersTopic {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return ArrayList<ArrayList<Int>>()
        nums.sort()
        val set = HashSet<List<Int>>()
        for (i in 0 until nums.size - 2) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        set.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                        k--
                    }
                    sum > 0 -> k--
                    else -> j++
                }
            }
        }
        return ArrayList(set)
    }
}

fun main() {
    println(Solution15().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
    println(Solution15().threeSum(intArrayOf()))
    println(Solution15().threeSum(intArrayOf(0)))
}