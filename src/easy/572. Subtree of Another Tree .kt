package easy

import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.
 */

class Easy572 : TreeTopic, BinaryTreeTopic, DFSTopic {

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        root ?: return false
        subRoot ?: return false
        return isSubtree1(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSubtree1(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        root ?: return false
        subRoot ?: return false
        if (root.`val` != subRoot.`val`) return false
        return isSubtree1(root.left, subRoot.left) && isSubtree1(root.right, subRoot.right)
    }
}