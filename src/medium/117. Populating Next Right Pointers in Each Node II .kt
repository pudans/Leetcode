package medium

import BFSTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic

/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 */

class Medium117 : TreeTopic, BinaryTreeTopic, DFSTopic, BFSTopic {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    val map = HashMap<Int, Node>()

    fun connect(root: Node?, level: Int = 0): Node? {
        root ?: return null
        if (map[level] != null) map[level]?.next = root
        map[level] = root
        connect(root.left, level + 1)
        connect(root.right, level + 1)
        return root
    }
}