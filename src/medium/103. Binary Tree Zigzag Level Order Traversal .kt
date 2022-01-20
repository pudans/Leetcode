package medium

import BFSTopic
import BinaryTreeTopic
import TreeTopic
import utils.TreeNode
import java.util.*

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right,
 * then right to left for the next level and alternate between).
 */

class Medium103 : TreeTopic, BFSTopic, BinaryTreeTopic {

    val result = ArrayList<List<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        traverse(root)
        return result
    }

    private fun traverse(root: TreeNode, level: Int = 0) {
        val dd = result.getOrElse(level) { LinkedList() } as LinkedList<Int>
        if (level % 2 == 1) dd.addFirst(root.`val`) else dd.addLast(root.`val`)
        if (result.size <= level) result.add(dd) else result[level] = dd
        root.left?.let { traverse(it, level + 1) }
        root.right?.let { traverse(it, level + 1) }
    }
}