package easy

import utils.TreeNode

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

class Easy104 {

    fun maxDepth(root: TreeNode?): Int =
        when (root) {
            null -> 0
            else -> 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
        }
}