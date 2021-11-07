package medium

import ArraysTopic
import MathTopic
import TwoPointersTopic

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

class Medium189 : ArraysTopic, TwoPointersTopic, MathTopic {

    fun rotate(nums: IntArray, k: Int): Unit {
        val clone = nums.clone()
        for (i in nums.indices) {
            nums[(i + k) % nums.size] = clone[i]
        }
    }
}