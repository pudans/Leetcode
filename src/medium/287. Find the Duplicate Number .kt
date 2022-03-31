package medium

import ArraysTopic
import BinaryTreeTopic
import BitManipulationTopic
import TwoPointersTopic

/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
 */

class Medium287 : ArraysTopic, TwoPointersTopic, BinaryTreeTopic, BitManipulationTopic {

    fun findDuplicate(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        val map = HashMap<Int, Boolean>()
        nums.forEach {
            if (map[it] == true) return it
            map[it] = true
        }
        return 0
    }
}

fun main() {
    println(Medium287().findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    println(Medium287().findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
}