package easy

import utils.TreeNode

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

class Easy110 {

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left)
    }

    private fun getHeight(root: TreeNode?, currentHeight: Int = 0): Int {
        if (root == null) return currentHeight
        return Math.max(
            getHeight(root.right, currentHeight = currentHeight + 1),
            getHeight(root.left, currentHeight = currentHeight + 1)
        )
    }
}