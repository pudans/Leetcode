package easy

import utils.TreeNode

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 */

class Easy404 {

    var sum = 0

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        calculate(root)
        return sum
    }

    private fun calculate(root: TreeNode?) {
        root?.let { node ->
            node.left?.let {
                if (it.left == null && it.right == null) {
                    sum += it.`val`
                } else {
                    calculate(it)
                }
            }
            node.right?.let { calculate(it) }
        }
    }
}