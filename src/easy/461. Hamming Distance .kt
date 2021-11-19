package easy

import BitManipulationTopic

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/
 *
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.
 */

class Easy461 : BitManipulationTopic {

    fun hammingDistance(x: Int, y: Int): Int {
        var xx = x
        var yy = y
        var result = 0
        for (i in 30 downTo 0) {
            val g = Math.pow(2.0, i.toDouble()).toInt()
            val d1 = xx >= g
            val d2 = yy >= g
            if (d1 != d2) result++
            if (d1) xx-=g
            if (d2) yy-=g
        }
        return result
    }
}

fun main() {
    println(Easy461().hammingDistance(1, 4))
    println(Easy461().hammingDistance(3, 1))
}