package easy

import ArraysTopic

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

class Easy136 : ArraysTopic {

    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach { value ->
            when (set.contains(value)) {
                true -> set.remove(value)
                false -> set.add(value)
            }
        }
        return set.first()
    }
}

fun main() {
    println(Easy136().singleNumber(intArrayOf(2, 2, 1)))
    println(Easy136().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(Easy136().singleNumber(intArrayOf(1)))
}