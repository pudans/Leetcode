package medium

import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

class Medium98: TreeTopic, BinaryTreeTopic, BinarySearchTopic, DFSTopic {

    fun isValidBST(node: TreeNode?, min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE): Boolean {
        node ?: return true
        if (node.`val` <= min || node.`val` >= max) return false
        return isValidBST(node.left, min, node.`val`.toLong()) && isValidBST(node.right, node.`val`.toLong(), max)
    }
}