package medium

import ArraysTopic
import BinarySearchTopic

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */

class Medium34: ArraysTopic, BinarySearchTopic {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = nums.binarySearch(target)
        if (index < 0) {
            return intArrayOf(-1,-1)
        }
        var start = index
        var end = index
        while (start > 0) {
            if (nums[start - 1] == target) {
                start--
            } else {
                break
            }
        }
        while (end < nums.size - 1) {
            if (nums[end + 1] == target) {
                end++
            } else {
                break
            }
        }
        return intArrayOf(start, end)
    }
}

fun main() {
    println(Medium34().searchRange(intArrayOf(5,7,7,8,8,10), 8).toList())
    println(Medium34().searchRange(intArrayOf(5,7,7,8,8,10), 6).toList())
    println(Medium34().searchRange(intArrayOf(), 0).toList())
}