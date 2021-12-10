package easy

import SortingTopic
import TwoPointersTopic


/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */

class Easy977 : TwoPointersTopic, SortingTopic {

    fun sortedSquares(nums: IntArray): IntArray {
        var start = 0
        var end = nums.lastIndex
        var index = end
        val ans = IntArray(nums.size)
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                ans[index--] = nums[start] * nums[start++]
            } else {
                ans[index--] = nums[end] * nums[end--]
            }
        }
        return ans
    }

    fun sortedSquares1(nums: IntArray): IntArray {
        return nums.sortedBy { Math.abs(it) }.map { it * it }.toIntArray()
    }
}

fun main() {
    println(Easy977().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).toList())
    println(Easy977().sortedSquares(intArrayOf(-7, -3, 2, 3, 11)).toList())
}