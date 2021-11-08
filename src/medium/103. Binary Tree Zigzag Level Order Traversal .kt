package medium

import BFSTopic
import BinaryTreeTopic
import TreeTopic
import utils.TreeNode

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right,
 * then right to left for the next level and alternate between).
 */

class Medium103: TreeTopic, BFSTopic, BinaryTreeTopic {

    // [3,9,20,99,88,15,7,1,2,3,4,5,6,7,8]

    val result = ArrayList<ArrayList<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root?.let { traverse(root) }
        for (i in result.indices) {
            if (i % 2 == 0) {
                result[i] = ArrayList(result[i].reversed())
            }
        }
        return result
    }

    private fun traverse(root: TreeNode, level: Int = 0) {
        val dd = result.getOrElse(level) { ArrayList(level * 2) }
        dd.add(root.`val`)
        if (result.size <= level) result.add(dd) else result[level] = dd

        root.left?.let { traverse(it, level + 1) }
        root.right?.let { traverse(it, level + 1) }
    }
}