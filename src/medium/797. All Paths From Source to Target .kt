package medium

import BFSTopic
import BacktrackingTopic
import DFSTopic
import java.util.*

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */

class Medium797 : BacktrackingTopic, DFSTopic, BFSTopic {

    fun allPathsSourceTarget(
        graph: Array<IntArray>,
        index: Int = 0,
        current: ArrayList<Int> = ArrayList(),
        result: ArrayList<List<Int>> = ArrayList()
    ): ArrayList<List<Int>> {
        current.add(index)
        if (index == graph.lastIndex) {
            result.add(current)
        } else {
            for (i in 0 until graph[index].size) {
                allPathsSourceTarget(graph, graph[index][i], ArrayList(current), result)
            }
        }
        return result
    }
}

fun main() {
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf())))
    println(
        Medium797().allPathsSourceTarget(
            arrayOf(
                intArrayOf(4, 3, 1),
                intArrayOf(3, 2, 4),
                intArrayOf(3),
                intArrayOf(4),
                intArrayOf()
            )
        )
    )
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1, 2, 3), intArrayOf(2), intArrayOf(3), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1, 3), intArrayOf(2), intArrayOf(3), intArrayOf())))
}