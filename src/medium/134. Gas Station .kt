package medium

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 */

class Medium134 {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val size = gas.size
        for (i in gas.indices) {
            if (gas[i] < cost[i]) continue
            var currGas = gas[i]
            for (j in i..(i + size)) {
                if (j == i + size) return i
                val index = if (j > size - 1) j - size else j
                if (i != j) {
                    currGas += gas[index]
                }
                if (cost[index] > currGas) {
                    break
                } else {
                    currGas -= cost[index]
                }
            }
        }
        return -1
    }
}

fun main() {
    println(Medium134().canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)))
    println(Medium134().canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3)))
}