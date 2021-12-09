package medium

import ArraysTopic
import BFSTopic
import DFSTopic

/**
 * 1306. Jump Game III
 * https://leetcode.com/problems/jump-game-iii/
 *
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.
 */

class Medium1306 : ArraysTopic, BFSTopic, DFSTopic {

    val map = HashMap<Int, Boolean>()

    fun canReach(arr: IntArray, start: Int): Boolean {
        val dis = arr.getOrNull(start) ?: return false
        if (dis == 0) return true
        if (map[start] == true) return false
        map[start] = true
        if (canReach(arr, start + dis)) return true
        if (canReach(arr, start - dis)) return true
        return false
    }
}

fun main() {
    println(Medium1306().canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    println(Medium1306().canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
    println(Medium1306().canReach(intArrayOf(3, 0, 2, 1, 2), 2))
}