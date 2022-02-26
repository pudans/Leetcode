package hard

import BFSTopic
import BitManipulationTopic
import DFSTopic
import DynamicProgrammingTopic
import GreedyTopic
import java.util.*


/**
 * 847. Shortest Path Visiting All Nodes
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 *
You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times,
and you may reuse edges.

 BULLSHIT
 */

class Hard847 : DynamicProgrammingTopic, DFSTopic, BFSTopic, GreedyTopic, BitManipulationTopic {

    fun shortestPathLength(graph: Array<IntArray>): Int {
        if (graph.size == 1) return 0
        val endingMask = (1 shl graph.size) - 1
        val seen = Array(graph.size) { BooleanArray(endingMask) }
        var queue = ArrayList<IntArray>()
        for (i in graph.indices) {
            queue.add(intArrayOf(i, 1 shl i))
            seen[i][1 shl i] = true
        }
        var steps = 0
        while (queue.isNotEmpty()) {
            val nextQueue = ArrayList<IntArray>()
            for (i in queue.indices) {
                val currentPair = queue[i]
                val node = currentPair[0]
                val mask = currentPair[1]
                for (neighbor in graph[node]) {
                    val nextMask = mask or (1 shl neighbor)
                    if (nextMask == endingMask) {
                        return 1 + steps
                    }
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true
                        nextQueue.add(intArrayOf(neighbor, nextMask))
                    }
                }
            }
            steps++
            queue = nextQueue
        }
        return -1
    }
}