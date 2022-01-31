package medium

import BFSTopic
import DFSTopic
import UnionFindTopic

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
 *
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
BULLSHIT
 */

class Medium547 : DFSTopic, BFSTopic, UnionFindTopic {

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var count = 0
        val visited = HashSet<Int>()
        for (i in isConnected.indices) {
            if (!visited.contains(i)) {
                count++
                dfsUtil(isConnected, i, visited)
            }
        }
        return count
    }

    private fun dfsUtil(isConnected: Array<IntArray>, vertex: Int, visited: HashSet<Int>) {
        visited.add(vertex)
        for (j in isConnected[vertex].indices) {
            if (isConnected[vertex][j] == 1 && !visited.contains(j)) {
                dfsUtil(isConnected, j, visited)
            }
        }
    }

    // mine
    fun findCircleNum1(isConnected: Array<IntArray>): Int {
        val result = mutableListOf<HashSet<Int>>()
        for (i in isConnected.indices) {
            val ind = result.indexOfFirst { it.contains(i) }
            val set = if (ind == -1) hashSetOf(i) else result[ind]
            for (j in i until isConnected.size) {
                if (isConnected[i][j] == 1) {
                    set.add(j)
                }
            }
            if (ind == -1) result.add(set) else result[ind] = set
        }
        result.forEach { println(it.toList()) }
        return result.size
    }
}

fun main() {
    println(Medium547().findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
    println(Medium547().findCircleNum(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))))
    println(
        Medium547().findCircleNum(
            arrayOf(
                intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 0, 1, 1)
            )
        )
    )
}