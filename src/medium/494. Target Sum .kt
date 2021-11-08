package medium

import BacktrackingTopic
import DynamicProgrammingTopic

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 *
 * You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
 */

class Medium494 : DynamicProgrammingTopic, BacktrackingTopic {

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        if (nums.size == 0) {
            return 0
        }
        return findTargetSumWays(nums, target, 0, 0)
    }

    fun findTargetSumWays(nums: IntArray, target: Int, result: Int, position: Int): Int {

        if (position == nums.size - 1) {
            var dd = 0
            if (result - nums[position] == target) {
                dd++
            }
            if (result + nums[position] == target) {
                dd++
            }
            return dd
        } else {
            return findTargetSumWays(nums, target, result + nums[position], position + 1) +
                    findTargetSumWays(nums, target, result - nums[position], position + 1)
        }
    }
}

fun main() {
    println(Medium494().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
}