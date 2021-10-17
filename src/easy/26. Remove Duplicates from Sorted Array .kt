package easy

import ArraysTopic
import TwoPointersTopic

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

class Easy26: ArraysTopic, TwoPointersTopic {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) return 1
        var result = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i-1]) {
                nums[result] = nums[i]
                result++
            }
        }
        return result
    }
}

fun main() {
    val example1 = intArrayOf(1,1,2)
    println(Easy26().removeDuplicates(example1))
    println(example1.toList())

    val example2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(Easy26().removeDuplicates(example2))
    println(example2.toList())
}