package easy

import utils.TreeNode

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */

class Solution534 {

    var result = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return result - 1
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftDepth = depth(root.left)
        val rightDepth = depth(root.right)
        result = Math.max(rightDepth + leftDepth + 1, result)
        return Math.max(rightDepth, leftDepth) + 1
    }
}