package easy

import BFSTopic
import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import utils.TreeNode

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 *
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 */

class Easy938 : BinaryTreeTopic, BinarySearchTopic, BFSTopic, DFSTopic {

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        root ?: return 0
        val result = if (root.`val` in low..high) root.`val` else 0
        return result + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}