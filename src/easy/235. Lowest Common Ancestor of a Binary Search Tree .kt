package easy

import BFSTopic
import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */

class Easy235 : BFSTopic, BinarySearchTopic, DFSTopic, TreeTopic, BinaryTreeTopic {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        if (root == p || root == q) return root
        val right = lowestCommonAncestor(root.right, p, q)
        val left = lowestCommonAncestor(root.left, p, q)
        if (right != null && left != null) return root
        return right ?: left
    }
}