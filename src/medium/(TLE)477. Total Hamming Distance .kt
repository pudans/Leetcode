package medium

import BitManipulationTopic

/**
 * 477. Total Hamming Distance
 * https://leetcode.com/problems/total-hamming-distance/
 *
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 */

class Medium477 : BitManipulationTopic {

    fun totalHammingDistance(nums: IntArray): Int {
        var result = 0
        for (z in 30 downTo 0) {
            val g = Math.pow(2.0, z.toDouble()).toInt()
            for (i in nums.indices) {
                for (j in i + 1 until nums.size) {
                    if (nums[i] >= g != nums[j] >= g) result++
                }
                if (nums[i] >= g) nums[i]-=g
            }
        }
        return result
    }
}

fun main() {
    println(Medium477().totalHammingDistance(intArrayOf(4,2,14)))
    println(Medium477().totalHammingDistance(intArrayOf(4,14,4)))
}