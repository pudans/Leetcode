package easy

import ArraysTopic

/**
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 *
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

class Easy941 : ArraysTopic {

    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false

        var heap = -1

        for (i in 1 until arr.size) {
            if (arr[i] == arr[i - 1]) return false
            if (arr[i] > arr[i - 1] && heap != -1) return false
            if (arr[i] < arr[i - 1] && heap == -1) {
                heap = i - 1
            }
            if (arr[i] < arr[i - 1] && heap == -1) return false
        }
        return heap > 0
    }
}

fun main() {
    println(Easy941().validMountainArray(intArrayOf(2, 1)))
    println(Easy941().validMountainArray(intArrayOf(3, 5, 5)))
    println(Easy941().validMountainArray(intArrayOf(0, 3, 2, 1)))
    println(Easy941().validMountainArray(intArrayOf(0, 2, 3, 4, 5, 2, 1, 0)))
    println(Easy941().validMountainArray(intArrayOf(0, 2, 3, 3, 5, 2, 1, 0)))
    println(Easy941().validMountainArray(intArrayOf(6, 5, 4, 3, 2, 1)))
}