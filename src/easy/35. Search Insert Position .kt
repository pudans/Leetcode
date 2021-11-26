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
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            if (start == end) return if (nums[start] >= target) start else start + 1
            if (nums[start] == target) return start
            if (nums[end] == target) return end
            val mid = (start + end) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return if (nums[start] >= target) start else start + 1
    }

    fun searchInsert1(nums: IntArray, target: Int): Int {
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
    println(Easy35().searchInsert(nums = intArrayOf(1), target = 1))
    println(Easy35().searchInsert(nums = intArrayOf(3,5,7,9,10), target = 8))
}