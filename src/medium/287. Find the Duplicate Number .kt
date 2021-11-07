package medium

import ArraysTopic
import BinaryTreeTopic
import BitManipulationTopic
import TwoPointersTopic

/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 */

class Medium287 : ArraysTopic, TwoPointersTopic, BinaryTreeTopic, BitManipulationTopic {

    fun findDuplicate(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val map = HashMap<Int,Int>()
        nums.forEach {
            if (map.getOrDefault(it, 0) == 1) {
                return it
            } else {
                map.set(it, 1)
            }
        }
        return 0
    }
}