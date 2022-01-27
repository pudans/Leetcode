package medium

import BitManipulationTopic
import HashTableTopic
import TrieTopic

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 */

class Medium421 : HashTableTopic, BitManipulationTopic, TrieTopic {

    fun findMaximumXOR(nums: IntArray): Int {
        var result = 0
        var mask = 0
        for (i in 31 downTo 0) {
            mask = mask or (1 shl i)
            val set = HashSet<Int>()
            for (n in nums) {
                set.add(n and mask)
            }
            val temp = result or (1 shl i)
            for (it in set) {
                if (set.contains(it xor temp)) {
                    result = temp
                    break
                }
            }
        }
        return result
    }

    //mine
    fun findMaximumXOR1(nums: IntArray): Int {
        var result = nums.first()
        for (i in 0 until nums.lastIndex) {
            for (j in (i + 1) until nums.size) {
                result = maxOf(result, nums[i] xor nums[j])
            }
        }
        return result
    }
}

fun main() {
    println(Medium421().findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8)))
    println(Medium421().findMaximumXOR(intArrayOf(14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70)))
}