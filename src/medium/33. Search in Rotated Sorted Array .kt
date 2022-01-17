package medium

import ArraysTopic
import BinarySearchTopic

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */

class Medium33 : BinarySearchTopic, ArraysTopic {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) return if (nums.first() == target) 0 else -1;
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[start] == target) return start
            if (nums[end] == target) return end
            if (nums[mid] == target) return mid
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }
        return -1
    }
}

fun main() {
    println(Medium33().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    println(Medium33().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    println(Medium33().search(intArrayOf(1), 0))
}