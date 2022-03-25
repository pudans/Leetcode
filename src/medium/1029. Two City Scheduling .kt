package medium

import ArraysTopic
import GreedyTopic
import SortingTopic

/**
 * 1029. Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 *
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti],
the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 */

class Medium1029 : ArraysTopic, GreedyTopic, SortingTopic {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val sorted = costs.sortedArrayWith(Comparator { a, b -> (a[0] - a[1]) - (b[0] - b[1]) })
        var result = 0
        for (i in costs.indices) {
            result += if (i >= sorted.size / 2) sorted[i][1] else sorted[i][0]
        }
        return result
    }
}

fun main() {
    println(
        Medium1029().twoCitySchedCost(
            arrayOf(
                intArrayOf(10, 20),
                intArrayOf(30, 200),
                intArrayOf(400, 50),
                intArrayOf(30, 20)
            )
        )
    )
    println(
        Medium1029().twoCitySchedCost(
            arrayOf(
                intArrayOf(259, 770),
                intArrayOf(448, 54),
                intArrayOf(926, 667),
                intArrayOf(184, 139),
                intArrayOf(840, 118),
                intArrayOf(577, 469)
            )
        )
    )
    println(
        Medium1029().twoCitySchedCost(
            arrayOf(
                intArrayOf(515, 563),
                intArrayOf(451, 713),
                intArrayOf(537, 709),
                intArrayOf(343, 819),
                intArrayOf(855, 779),
                intArrayOf(457, 60),
                intArrayOf(650, 359),
                intArrayOf(631, 42)
            )
        )
    )
}