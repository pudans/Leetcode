package easy

import utils.TreeNode

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */

class Easy226 {

    fun invertTree(root: TreeNode?): TreeNode? {
        swap(root)
        return root
    }

    private fun swap(root: TreeNode?) {
        val temp = root?.left
        root?.left = root?.right
        root?.right = temp
        root?.left?.let { swap(it) }
        root?.right?.let { swap(it) }
    }
}