package easy

import DynamicProgrammingTopic

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
 */

class Easy746 : DynamicProgrammingTopic {

    fun minCostClimbingStairs(cost: IntArray): Int {
        val map = IntArray(cost.size + 1)
        map[0] = cost[0]
        map[1] = cost[1]
        for (i in 2 until cost.size + 1) {
            map[i] = minOf(map[i - 1], map[i - 2]) + (cost.getOrNull(i) ?: 0)
        }
        return map.last()
    }
}

fun main() {
    println(Easy746().minCostClimbingStairs(intArrayOf(10, 15, 20)))
    println(Easy746().minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
}