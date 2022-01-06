package easy

import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import utils.TreeNode

/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
Given the root of a Binary Search Tree and a target number k,
return true if there exist two elements in the BST such that their sum is equal to the given target.
 */

class Easy653 : BinarySearchTopic, DFSTopic, BinaryTreeTopic {

    val list = mutableListOf<Int>()

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        root ?: return false
        list.forEach { if (it + root.`val` == k) return true }
        list.add(root.`val`)
        return findTarget(root.left, k) || findTarget(root.right, k)
    }
}