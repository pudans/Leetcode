package medium

import utils.TreeNode

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val,
 * and any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 */

class Medium1008 {

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val root = TreeNode(preorder.first())
        for (i in 1 until preorder.size) {
            insert(root, preorder[i])
        }
        return root
    }

    private fun insert(node: TreeNode, value: Int) {
        when {
            value <= node.`val` && node.left == null -> node.left = TreeNode(value)
            value <= node.`val` -> insert(node.left!!, value)
            node.right == null -> node.right = TreeNode(value)
            else -> insert(node.right!!, value)
        }
    }
}