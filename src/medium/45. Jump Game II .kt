package medium

import ArraysTopic
import DynamicProgrammingTopic
import GreedyTopic

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 */

class Medium45: ArraysTopic, DynamicProgrammingTopic, GreedyTopic {

    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentJumpEnd = 0
        var farthest = 0
        for (i in 0 until nums.size - 1) {
            farthest = Math.max(farthest, i + nums[i])
            if (i == currentJumpEnd) {
                jumps++
                currentJumpEnd = farthest
            }
        }
        return jumps
    }
}

fun main() {
    println(Medium45().jump(intArrayOf(2,3,1,1,4)))
    println(Medium45().jump(intArrayOf(2,3,0,1,4)))
    println(Medium45().jump(intArrayOf(2,0,2,4,6,0,0,3)))
    println(Medium45().jump(intArrayOf(1,2,1,1,1)))
}