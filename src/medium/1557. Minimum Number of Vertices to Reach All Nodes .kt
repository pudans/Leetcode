package medium

import java.util.*

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *
Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
Find the smallest set of vertices from which all nodes in the graph are reachable.
It's guaranteed that a unique solution exists.
Notice that you can return the vertices in any order.
 */

class Medium1557 {

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val set = HashSet<Int>()
        repeat(n) { set.add(it) }
        edges.forEach { edge ->
            set.remove(edge[1])
        }
        return set.toList()
    }
}

fun main() {
    println()
}