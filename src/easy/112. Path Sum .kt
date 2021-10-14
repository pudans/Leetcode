package easy

import utils.TreeNode

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */

class Easy112 {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false
        return isPathSum(root, sum)
    }

    private fun isPathSum(root: TreeNode, targetSum: Int, currentSum: Int = 0): Boolean {
        val newSum = currentSum + root.`val`
        return when {
            root.left == null && root.right == null -> newSum == targetSum
            root.left != null && root.right != null ->
                isPathSum(root.right!!, targetSum, newSum) || isPathSum(root.left!!, targetSum, newSum)
            root.left != null -> isPathSum(root.left!!, targetSum, newSum)
            else -> isPathSum(root.right!!, targetSum, newSum)
        }
    }
}