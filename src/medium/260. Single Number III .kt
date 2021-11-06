package medium

import ArraysTopic
import BitManipulationTopic

/**
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 */

class Medium260 : ArraysTopic, BitManipulationTopic {

    fun singleNumber(nums: IntArray): IntArray {
        val set = HashSet<Int>()
        nums.forEach { num ->
            when (set.contains(num)) {
                true -> set.remove(num)
                false -> set.add(num)
            }
        }
        return set.toIntArray()
    }
}

fun main() {
    println(Medium260().singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).toList())
    println(Medium260().singleNumber(intArrayOf(-1, 0)).toList())
    println(Medium260().singleNumber(intArrayOf(0, 1)).toList())

}