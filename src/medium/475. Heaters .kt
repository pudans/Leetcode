package medium

import BinarySearchTopic
import SortingTopic

/**
 * 475. Heaters
 * https://leetcode.com/problems/heaters/
 *
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
Every house can be warmed, as long as the house is within the heater's warm radius range.
Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
Notice that all the heaters follow your radius standard, and the warm radius will the same.
 */

class Medium475 : BinarySearchTopic, SortingTopic {

    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        var result = 0
        for (i in houses.indices) {
            var resultForHouse = Int.MAX_VALUE
            for (j in heaters.indices) {
                val dd = Math.abs(houses[i] - heaters[j])
                if (dd < resultForHouse) {
                    resultForHouse = dd
                }
            }
            println("${houses[i]} $resultForHouse")
            if (resultForHouse > result) {
                result = resultForHouse
            }
        }
        return result
    }

    fun findRadius2(houses: IntArray, heaters: IntArray): Int {
        var maxRadius = 0
        var currRadius = 0
        for (i in houses.indices) {
            if (heaters.contains(houses[i])) {
                if (maxRadius < currRadius) {
                    maxRadius = currRadius
                    currRadius = 0
                }
            } else {
                currRadius++
            }
        }
        if (maxRadius < currRadius) {
            maxRadius = currRadius
        }
        return Math.ceil(maxRadius / 2.0).toInt()
    }

    fun findRadius3(houses: IntArray, heaters: IntArray): Int {
        var result = 0

        val min = Math.min(houses.first(), heaters.first())
        val max = Math.max(houses.last(), heaters.last())

        var currHeater = -1
        var currHouse = -1

        var isHeater = houses[min] == min
        var prevPos = min

        for (i in min..max) {
            if (currHeater >= 0 && currHouse >= 0 && heaters[currHeater] == i) {
                val dd = i - houses[currHouse]
                if (dd > result) {
                    result = dd
                }
                continue
            }
            if (currHeater < 0) {
                currHeater = 0
            }
        }

        return result
    }
}

fun main() {
    println(Medium475().findRadius(intArrayOf(1, 2, 3, 4), intArrayOf(1, 4)))
}