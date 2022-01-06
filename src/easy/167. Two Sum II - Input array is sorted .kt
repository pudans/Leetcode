package easy

import TwoPointersTopic

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */

class Easy167 : TwoPointersTopic {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0 until numbers.lastIndex) {
            val first = numbers[i]
            for (j in (i + 1) until numbers.size) {
                val second = numbers[j]
                if (first + second == target) return intArrayOf(i + 1, j + 1)
                if (first + second > target) break
            }
        }
        return intArrayOf()
    }
}

fun main() {
    println(Easy167().twoSum(intArrayOf(2, 7, 11, 15), 9).toList())
    println(Easy167().twoSum(intArrayOf(2, 3, 4), 6).toList())
    println(Easy167().twoSum(intArrayOf(-1, 0), -1).toList())
}