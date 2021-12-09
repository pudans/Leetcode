package easy

import BinarySearchTopic

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 *
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
 */

class Easy704 : BinarySearchTopic {

    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return -1
    }
}

fun main() {
    println(Easy704().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(Easy704().search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
}