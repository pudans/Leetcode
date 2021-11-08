package medium

import ArraysTopic
import TwoPointersTopic


/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 *
 * BULLSHIT
 */

class Medium31: ArraysTopic, TwoPointersTopic {

    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2
        while (i >= 0 && nums[i + 1] <= nums[i]) i--
        if (i >= 0) {
            var j = nums.size - 1
            while (nums[j] <= nums[i]) j--
            swap(nums, i, j)
        }
        reverse(nums, i + 1)
    }

    private fun reverse(nums: IntArray, start: Int) {
        var i = start
        var j = nums.size - 1
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[j].also { nums[j] = nums[i] }
    }
}

fun main() {
    var array = intArrayOf(1,5,8,4,7,6,5,3,1)
    Medium31().nextPermutation(array)
    println(array.toList())

    array = intArrayOf(1,2,3)
    Medium31().nextPermutation(array)
    println(array.toList())

    array = intArrayOf(3,2,1)
    Medium31().nextPermutation(array)
    println(array.toList())

    array = intArrayOf(1,1,5)
    Medium31().nextPermutation(array)
    println(array.toList())

    array = intArrayOf(1)
    Medium31().nextPermutation(array)
    println(array.toList())

    array = intArrayOf(1,3,2)
    Medium31().nextPermutation(array)
    println(array.toList())
}