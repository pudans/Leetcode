package medium

import BFSTopic
import BinaryTreeTopic
import TreeTopic
import utils.TreeNode

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

class Medium102: TreeTopic, BFSTopic, BinaryTreeTopic {

    private val result = ArrayList<ArrayList<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        traverse(0, root)
        return result
    }

    fun traverse(level: Int, root: TreeNode) {
        val dd = result.getOrElse(level) { ArrayList(level * 2) }
        dd.add(root.`val`)
        if (result.size <= level) {
            result.add(dd)
        } else {
            result[level] = dd
        }

        root.left?.let { traverse(level + 1, it) }
        root.right?.let { traverse(level + 1, it) }
    }
}