package easy

import BinaryTreeTopic
import DFSTopic
import StackTopic
import Tree.Traversal.DFS.preOrder
import TreeTopic
import utils.TreeNode

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

class Easy144 : DFSTopic, BinaryTreeTopic, TreeTopic, StackTopic {

    val list = mutableListOf<Int>()

    fun preorderTraversal(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        list.add(root.`val`)
        preorderTraversal(root.left)
        preorderTraversal(root.right)
        return list
    }
}