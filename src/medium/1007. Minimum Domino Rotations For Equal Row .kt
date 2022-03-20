package medium

import ArraysTopic
import GreedyTopic

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
If it cannot be done, return -1.
 */

class Medium1007 : ArraysTopic, GreedyTopic {

    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        var result = Int.MAX_VALUE
        for (i in 1..6) {
            var resTop = 0
            var resBottom = 0
            for (j in tops.indices) {
                if (resTop >= 0) {
                    if (i != tops[j]) {
                        if (i != bottoms[j]) resTop = -1 else resTop++
                    }
                }
                if (resBottom >= 0) {
                    if (i != bottoms[j]) {
                        if (i != tops[j]) resBottom = -1 else resBottom++
                    }
                }
                if (resTop >= result && resBottom >= result) break
            }
            if (resTop >= 0) result = minOf(result, resTop)
            if (resBottom >= 0) result = minOf(result, resBottom)
        }
        return if (result == Int.MAX_VALUE) -1 else result
    }
}

fun main() {
    println(Medium1007().minDominoRotations(intArrayOf(2, 1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
    println(Medium1007().minDominoRotations(intArrayOf(3, 5, 1, 2, 3), intArrayOf(3, 6, 3, 3, 4)))
    println(Medium1007().minDominoRotations(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1), intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
}