package medium

import BFSTopic
import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode
import java.util.*

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */

class Medium230 : TreeTopic, DFSTopic, BFSTopic, BinarySearchTopic, BinaryTreeTopic {

    private val result = TreeSet<Int>()

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        root?.let { go(root) }
        return result.elementAt(k)
    }

    private fun go(root: TreeNode) {
        root.left?.let { go(it) }
        result.add(root.`val`)
        root.right?.let { go(it) }
    }
}