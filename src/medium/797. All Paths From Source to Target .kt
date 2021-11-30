package medium

import BFSTopic
import BacktrackingTopic
import DFSTopic
import StackTopic
import Tree.Traversal.LevelOrder.result
import java.util.*
import kotlin.collections.ArrayList

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */

class Medium797 : BacktrackingTopic, DFSTopic, BFSTopic {

    val result = ArrayList<List<Int>>()
    lateinit var graph: Array<IntArray>

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        this.graph = graph
        find(0, ArrayList())
        return result
    }

    fun find(index: Int, current: ArrayList<Int>) {
        current.add(index)
        if (index == graph.lastIndex) {
            result.add(current)
        } else {
            val new = ArrayList(current)
            if (graph[index].isNotEmpty()) {
                find(graph[index].first(), current)
            }
            for (i in 1 until graph[index].size) {
                find(graph[index][i], ArrayList(new))
            }
        }
    }
}

fun main() {
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1,2), intArrayOf(3), intArrayOf(3), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(4,3,1), intArrayOf(3,2,4), intArrayOf(3), intArrayOf(4), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1,2,3), intArrayOf(2), intArrayOf(3), intArrayOf())))
    println(Medium797().allPathsSourceTarget(arrayOf(intArrayOf(1,3), intArrayOf(2), intArrayOf(3), intArrayOf())))
}