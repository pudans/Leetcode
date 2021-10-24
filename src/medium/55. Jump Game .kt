package medium

import ArraysTopic
import DynamicProgrammingTopic
import GreedyTopic

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */

class Medium55: ArraysTopic, GreedyTopic, DynamicProgrammingTopic {

    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) return true
        if (nums.size == 2) return nums[0] > 0
        val res = BooleanArray(nums.size)
        res[0] = true
        for (i in 0..(nums.size - 2)) {
            if (res[i]) {
                var j = i + 1
                while (j < nums.size && j < (i + 1 + nums[i])) {
                    res[j] = true
                    j++
                }
            }
        }
        println(res.toList())
        return res[nums.size - 1]
    }
}

fun main() {
    println(Medium55().canJump(intArrayOf(2,3,1,1,4)))
    println(Medium55().canJump(intArrayOf(3,2,1,0,4)))
}