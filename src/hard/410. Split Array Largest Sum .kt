package hard

import ArraysTopic
import BinarySearchTopic
import DynamicProgrammingTopic
import GreedyTopic


/**
 * 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/
 *
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.
 BULLSHIT
 */

class Hard410 : ArraysTopic, BinarySearchTopic, DynamicProgrammingTopic, GreedyTopic {

    lateinit var nums: IntArray

    fun splitArray(nums: IntArray, m: Int): Int {
        this.nums = nums
        var low = 0
        var high = 0
        var min = Int.MAX_VALUE
        for (i in nums.indices) {
            low = Math.max(low, nums[i])
            high += nums[i]
        }
        while (low <= high) {
            val mid = (low + high) / 2
            if (required_no_of_chunks(mid, m)) {
                min = Math.min(min, mid)
                high = mid - 1
            } else low = mid + 1
        }
        return min
    }

    private fun required_no_of_chunks(mid: Int, m: Int): Boolean {
        var chunks = 0
        var i = 0
        while (i < nums.size) {
            var `val` = 0
            while (i < nums.size && nums[i] + `val` <= mid) `val` += nums[i++]
            chunks++
        }
        return chunks <= m
    }
}