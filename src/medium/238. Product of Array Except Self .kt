package medium

import ArraysTopic


/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 BULLSHIT
 */

class Medium238 : ArraysTopic {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }
        var right = nums.last()
        for (i in (nums.size - 2) downTo 0) {
            result[i] = result[i] * right
            right *= nums[i]
        }
        return result
    }
}

fun main() {
    println(Medium238().productExceptSelf(intArrayOf(1,2,3,4)).toList())
}