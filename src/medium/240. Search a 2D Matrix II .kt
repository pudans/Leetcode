package medium

import BinarySearchTopic
import MatrixTopic

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/single-number-iii/
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 */

class Medium240 : MatrixTopic, BinarySearchTopic {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix.first().lastIndex
        while (i < matrix.size && j >= 0) {
            when {
                matrix[i][j] > target -> j--
                matrix[i][j] < target -> i++
                else -> return true
            }
        }
        return false
    }

    fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in matrix.indices) {
            val col = matrix[i]
            if (col.first() <= target && col.last() >= target) {
                if (col.binarySearch(target) >= 0) return true
            }
        }
        return false
    }
}

fun main() {
    println(
        Medium240().searchMatrix(
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30)
            ),
            5
        )
    )
}