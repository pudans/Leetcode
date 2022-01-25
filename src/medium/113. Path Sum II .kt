package medium

import BacktrackingTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 *
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */

class Medium113 : BacktrackingTopic, TreeTopic, DFSTopic, BinaryTreeTopic {

    val result = mutableListOf<List<Int>>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        go(root, targetSum, ArrayList(), 0)
        return result
    }

    private fun go(root: TreeNode?, targetSum: Int, path: MutableList<Int>, sum: Int) {
        root ?: return
        path.add(root.`val`)
        val newSum = sum + root.`val`
        if (root.left == null && root.right == null) {
            if (newSum == targetSum) result.add(path)
                return
        }
        go(root.left, targetSum, ArrayList(path), newSum)
        go(root.right, targetSum, ArrayList(path), newSum)
    }
}