package medium

import BinarySearchTopic

/**
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.
 */

class Medium540 : BinarySearchTopic {

    fun singleNonDuplicate(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            if (start == end) return nums[start]
            var mid = (start + end) / 2
            if (mid % 2 == 1) mid++
            println("$start - $mid - $end")
            when {
                (nums.getOrNull(mid + 1) != nums[mid] && nums.getOrNull(mid - 1) != nums[mid]) -> return nums[mid]
                nums.getOrNull(mid - 1) == nums[mid] -> end = mid - 1
                else -> start = mid
            }
        }
        return 0
    }
}

fun main() {
    println(Medium540().singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4,8,8)))
    println(Medium540().singleNonDuplicate(intArrayOf(3,3,7,7,10,11,11)))
}