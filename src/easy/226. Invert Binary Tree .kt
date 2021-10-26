package easy

import utils.TreeNode

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */

class Easy226 {

    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        left = right.also { right = left }
        invertTree(left)
        invertTree(right)
    }
}