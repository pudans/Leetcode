package easy

import TreeTopic
import utils.TreeNode

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */

class Easy64: TreeTopic {

    val result = ArrayList<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let { go(it) }
        return result
    }

    fun go(root: TreeNode) {
        root.left?.let { go(it) }
        result.add(root.`val`)
        root.right?.let { go(it) }
    }
}