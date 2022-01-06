package medium

import ArraysTopic
import SortingTopic
import java.util.*

/**
 * 1094. Car Pooling
 * https://leetcode.com/problems/car-pooling/
 *
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.
Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 */

class Medium1094 : ArraysTopic, SortingTopic {

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        var current = 0
        val map = HashMap<Int, Int>()
        val sorted = TreeSet<Int>()
        trips.forEach {
            map[it[1]] = map.getOrDefault(it[1], 0) + it[0]
            map[it[2]] = map.getOrDefault(it[2], 0) - it[0]
            sorted.add(it[1])
            sorted.add(it[2])
        }
        sorted.forEach {
            current += map[it] ?: 0
            if (current > capacity) return false
        }
        return true
    }
}

fun main() {
    println(Medium1094().carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 4))
    println(Medium1094().carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 5))
}