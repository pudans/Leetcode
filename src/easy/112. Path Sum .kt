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

    fun hasPathSum(root: TreeNode?, targetSum: Int, currentSum: Int = 0): Boolean =
        when {
            root == null -> false
            root.left == null && root.right == null -> currentSum + root.`val` == targetSum
            else -> hasPathSum(root.right!!, targetSum, currentSum + root.`val`)
                    || hasPathSum(root.left!!, targetSum, currentSum + root.`val`)
        }
}