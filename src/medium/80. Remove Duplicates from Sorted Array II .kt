package medium

import ArraysTopic
import TwoPointersTopic

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

class Medium80 : ArraysTopic, TwoPointersTopic {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 1
        var num = nums.first()
        var c = 1
        for (j in 1 until nums.size) {
            if (nums[j] != num || c < 2) {
                nums[i] = nums[j]
                i++
            }
            if (nums[j] == num) {
                c++
            } else {
                num = nums[j]
                c = 1
            }
        }
        return i
    }
}

fun main() {
    var array = intArrayOf(1, 1, 1, 2, 2, 3)
    println(Medium80().removeDuplicates(array))
    println(array.toList())

    array = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    println(Medium80().removeDuplicates(array))
    println(array.toList())
}