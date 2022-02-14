package easy

import BFSTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */

class Easy111 : TreeTopic, DFSTopic, BFSTopic {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return getHeight(root)
    }

    private fun getHeight(root: TreeNode?): Int =
        when {
            root == null -> Int.MAX_VALUE
            root.left == null && root.right == null -> 1
            else -> minOf(getHeight(root.right), getHeight(root.left)) + 1
        }
}