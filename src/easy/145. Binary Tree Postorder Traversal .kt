package easy

import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */

class Easy145 : DFSTopic, BinaryTreeTopic, TreeTopic {

    val list = mutableListOf<Int>()

    fun postorderTraversal(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        postorderTraversal(root.left)
        postorderTraversal(root.right)
        list.add(root.`val`)
        return list
    }
}