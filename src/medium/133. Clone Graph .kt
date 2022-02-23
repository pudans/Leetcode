package medium

import BFSTopic
import DFSTopic
import HashTableTopic

/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 *
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1,
the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class Medium133 : HashTableTopic, DFSTopic, BFSTopic {

    fun cloneGraph(node: Node?): Node? {
        node ?: return null
        val map = HashMap<Int, Node>()
        fun traverse(node: Node) {
            if (map.contains(node.`val`)) return
            val newNode = Node(node.`val`)
            newNode.neighbors = ArrayList()
            map[node.`val`] = newNode
            node.neighbors.forEach {
                traverse(it!!)
                newNode.neighbors.add(map[it.`val`]!!)
            }
        }
        traverse(node)
        return map[node.`val`]
    }
}