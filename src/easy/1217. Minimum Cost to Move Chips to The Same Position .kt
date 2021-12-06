package easy

import ArraysTopic
import GreedyTopic
import HashTableTopic
import MathTopic

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.
 *
 */

class Easy1217: ArraysTopic, MathTopic, GreedyTopic {

    fun minCostToMoveChips(position: IntArray): Int {
        var evenCount = 0
        var unEvenCount = 0
        position.forEach {
            when (it % 2 == 0) {
                true -> evenCount++
                false -> unEvenCount++
            }
        }
        return minOf(evenCount, unEvenCount)
    }
}

fun main() {
    println(Easy1217().minCostToMoveChips(intArrayOf(1,2,3)))
    println(Easy1217().minCostToMoveChips(intArrayOf(2,2,2,3,3)))
    println(Easy1217().minCostToMoveChips(intArrayOf(1,1000000000)))
}