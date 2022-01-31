package easy

import ArraysTopic

/**
 * 1929. Concatenation of Array
 * https://leetcode.com/problems/concatenation-of-array/
 *
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
Specifically, ans is the concatenation of two nums arrays.
Return the array ans.
 */

class Easy1929 : ArraysTopic {

    fun getConcatenation(nums: IntArray): IntArray =
        IntArray(nums.size * 2).also {
            for (i in nums.indices) {
                it[i] = nums[i]
                it[i + nums.size] = nums[i]
            }
        }
}

fun main() {
    println(Easy1929().getConcatenation(intArrayOf(1, 2, 1)))
    println(Easy1929().getConcatenation(intArrayOf(1, 3, 2, 1)))
}