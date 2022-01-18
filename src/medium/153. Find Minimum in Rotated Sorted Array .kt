package medium

import BinarySearchTopic


/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 *Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */

class Medium153 : BinarySearchTopic {

    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) return nums.first()
        var start = 0
        var end = nums.lastIndex
        while (start < end) {
            if (nums[start] < nums[end]) return nums[start]
            val mid = start + (end - start) / 2
            if (nums[mid] < nums[start]) end = mid else start = mid + 1
        }
        return nums[start]
    }
}

fun main() {
    println(Medium153().findMin(intArrayOf(3, 4, 5, 1, 2)))
    println(Medium153().findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    println(Medium153().findMin(intArrayOf(11, 13, 15, 17)))
}