package medium

import ArraysTopic
import BinarySearchTopic
import HashTableTopic
import MatrixTopic

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 */

class Medium74: ArraysTopic, BinarySearchTopic, MatrixTopic {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val r = matrix.size
        val c = matrix.first().size
        var start = 0
        var end = r * c - 1

        while (start <= end) {
            val mid = (start + end) / 2
            val res = matrix[mid / c][mid % c]
//            println("$start $end $mid $res")
            if (res == target) return true
            if (res > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return false
    }
}

fun main() {
    println(Medium74().searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 3))
    println(Medium74().searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 13))
    println(Medium74().searchMatrix(arrayOf(intArrayOf(1,3)), 3))
}