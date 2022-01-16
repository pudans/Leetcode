package medium

import ArraysTopic

/**
 * 849. Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
Return that maximum distance to the closest person.
 */

class Medium849 : ArraysTopic {

    fun maxDistToClosest(seats: IntArray): Int {
        var result = -1
        var current = 0
        for (i in seats.indices) {
            if (seats[i] == 0) {
                current++
            } else {
                if (result == -1) {
                    result = current
                } else {
                    current += if (current % 2 == 1) 1 else 0
                    result = maxOf(result, current / 2)
                }
                current = 0
            }
        }
        if (current > result) return current
        return maxOf(result, current)
    }
}

fun main() {
    println(Medium849().maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)))
    println(Medium849().maxDistToClosest(intArrayOf(1, 0, 0, 0)))
    println(Medium849().maxDistToClosest(intArrayOf(0, 1)))
    println(Medium849().maxDistToClosest(intArrayOf(0, 0, 1)))
}