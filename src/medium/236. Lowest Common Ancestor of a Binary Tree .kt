package medium

import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */

class Medium236 : TreeTopic, DFSTopic, BinaryTreeTopic {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        if (root == p || root == q) {
            return root
        }
        val right = lowestCommonAncestor(root.right, p, q)
        val left = lowestCommonAncestor(root.left, p, q)
        if (right != null && left != null) {
            return root
        }
        return right ?: left
    }
}

fun main() {
    val root = TreeNode(3)
    root.right = TreeNode(1)
    root.right?.right = TreeNode(8)
    root.right?.left = TreeNode(0)
    root.left = TreeNode(5)
    root.left?.right = TreeNode(2)
    root.left?.left = TreeNode(6)
    root.left?.right?.right = TreeNode(4)
    root.left?.right?.left = TreeNode(7)

    println(Medium236().lowestCommonAncestor(root, TreeNode(5), TreeNode(4)))
}