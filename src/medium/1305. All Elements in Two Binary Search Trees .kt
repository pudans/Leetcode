package medium

import BFSTopic
import BinaryTreeTopic
import DFSTopic
import utils.TreeNode

/**
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 */

class Medium1305 : BFSTopic, DFSTopic, BinaryTreeTopic {

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorder(root1, result)
        inorder(root2, result)
        return result.sorted()
    }

    private fun inorder(root: TreeNode?, arr: MutableList<Int>) {
        if (root == null) return
        inorder(root.left, arr)
        arr.add(root.`val`)
        inorder(root.right, arr)
    }
}