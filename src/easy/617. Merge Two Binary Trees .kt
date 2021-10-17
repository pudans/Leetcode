package easy

import utils.TreeNode

/**
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * Return the merged tree.
 * Note: The merging process must start from the root nodes of both trees.
 */

class Easy617 {

    fun mergeTrees(first: TreeNode?, second: TreeNode?): TreeNode? {

        if (first == null && second == null) {
            return null
        }

        if (first == null) {
            return second
        }

        if (second == null) {
            return first
        }

        mergeTrees11(first, second)

        return first
    }

    fun mergeTrees11(first: TreeNode, second: TreeNode) {
        first.`val` += second.`val`
        if (first.left != null && second.left != null) {
            mergeTrees11(first.left!!, second.left!!)
        } else if (first.left == null && second.left != null) {
            first.left = second.left
        }

        if (first.right != null && second.right != null) {
            mergeTrees11(first.right!!, second.right!!)
        } else if (first.right == null && second.right != null) {
            first.right = second.right
        }
    }
}