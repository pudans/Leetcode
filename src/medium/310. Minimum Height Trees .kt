package medium

import BFSTopic
import DFSTopic


/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/
 *
A tree is an undirected graph in which any two vertices are connected by exactly one path.
In other words, any connected graph without simple cycles is a tree.
Given a tree of n nodes labelled from 0 to n - 1,
and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree,
you can choose any node of the tree as the root.
When you select a node x as the root, the result tree has height h.
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 TLE
 BULLSHIT
 */

class Medium310: BFSTopic, DFSTopic {

    /**
     * TLE
     */
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val map = HashMap<Int,Int>()
        (0 until n).forEach { root ->

            fun findDepth(root: Int, set: HashSet<Int>, depth: Int): Int {
                if (edges.isEmpty()) return depth

                var res = 0
                for (i in edges.indices) {
                    val edge = edges[i]
                    if (edge[0] != root && edge[1] != root) continue
                    if (set.contains(edge[0])) continue
                    if (set.contains(edge[1])) continue
                    val d = if (edge[0] == root) edge[1] else edge[0]
                    set.add(root)
                    val f = findDepth(d, set, depth + 1)
                    if (f > res) {
                        res = f
                    }
                    set.remove(root)
                }

                return if (res == 0) depth else res
            }

            map[root] = findDepth(root, HashSet(), 0)
        }

        var tt = Int.MAX_VALUE
//        println(map)
        val dd = mutableListOf<Int>()
        map.entries.forEach {
            if (it.value < tt) {
                tt = it.value
                dd.clear()
            }
            if (it.value == tt) {
                dd.add(it.key)
            }
        }

        return dd
    }

    fun findMinHeightTrees1(n: Int, edges: Array<IntArray>): List<Int>? {

        // base cases
        if (n < 2) {
            val centroids = ArrayList<Int>()
            for (i in 0 until n) centroids.add(i)
            return centroids
        }

        // Build the graph with the adjacency list
        val neighbors = ArrayList<MutableSet<Int>>()
        for (i in 0 until n) neighbors.add(HashSet())
        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]
            neighbors[start].add(end)
            neighbors[end].add(start)
        }

        // Initialize the first layer of leaves
        var leaves = ArrayList<Int>()
        for (i in 0 until n) if (neighbors[i].size == 1) leaves.add(i)

        // Trim the leaves until reaching the centroids
        var remainingNodes = n
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size
            val newLeaves = ArrayList<Int>()

            // remove the current leaves along with the edges
            for (leaf in leaves) {
                // the only neighbor left for the leaf node
                val neighbor = neighbors[leaf].iterator().next()
                // remove the edge along with the leaf node
                neighbors[neighbor].remove(leaf)
                if (neighbors[neighbor].size == 1) newLeaves.add(neighbor)
            }

            // prepare for the next round
            leaves = newLeaves
        }

        // The remaining nodes are the centroids of the graph
        return leaves
    }
}

fun main() {
    println(Medium310().findMinHeightTrees(4, arrayOf(intArrayOf(1,0), intArrayOf(1,2), intArrayOf(1,3))))
    println(Medium310().findMinHeightTrees(6, arrayOf(intArrayOf(3,0), intArrayOf(3,1), intArrayOf(3,2), intArrayOf(3,4),
        intArrayOf(5,4)
    )))
    println(Medium310().findMinHeightTrees(1, arrayOf()))
    println(Medium310().findMinHeightTrees(2, arrayOf(intArrayOf(1,0))))

}