package easy

import utils.TreeNode

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 */

class Easy404 {

    fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean = false): Int {
        root ?: return 0
        if (isLeft && root.left == null && root.right == null) return root.`val`
        return sumOfLeftLeaves(root.left, isLeft = true) + sumOfLeftLeaves(root.right)
    }
}