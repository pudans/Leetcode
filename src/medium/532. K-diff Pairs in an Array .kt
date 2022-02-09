package medium

import ArraysTopic
import TwoPointersTopic

/**
 * 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
 */

class Medium532 : ArraysTopic, TwoPointersTopic {

    data class Point(val x: Int, val y: Int)

    fun findPairs(nums: IntArray, k: Int): Int {
        val set = HashSet<Point>()
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    val point = Point(maxOf(nums[i], nums[j]), minOf(nums[i], nums[j]))
                    set.add(point)
                }
            }
        }
        return set.size
    }
}

fun main() {
    println(Medium532().findPairs(intArrayOf(3, 1, 4, 1, 5), 2))
    println(Medium532().findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
    println(Medium532().findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
}