package easy

import ArraysTopic
import BinarySearchTopic

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

class Easy35: ArraysTopic, BinarySearchTopic {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var result = 0
        for (i in nums.indices) {
            when {
                nums[i] > target -> return result
                nums[i] == target -> return i
                nums[i] < target -> result = i + 1
            }
        }
        return result
    }
}

fun main() {
    println(Easy35().searchInsert(nums = intArrayOf(1,3,5,6), target = 5))
    println(Easy35().searchInsert(nums = intArrayOf(1,3,5,6), target = 2))
    println(Easy35().searchInsert(nums = intArrayOf(1,3,5,6), target = 7))
    println(Easy35().searchInsert(nums = intArrayOf(1,3,5,6), target = 0))
    println(Easy35().searchInsert(nums = intArrayOf(1), target = 0))
}