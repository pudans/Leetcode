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

    fun inorder(root: TreeNode?, arr: ArrayList<Int>): ArrayList<Int> {
        if (root == null) return arr
        inorder(root.left, arr)
        arr.add(root.`val`)
        inorder(root.right, arr)
        return arr
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val nums = inorder(root, ArrayList())
        return nums[k - 1]
    }

    // mine
    private val result = TreeSet<Int>()

    fun kthSmallest1(root: TreeNode?, k: Int): Int {
        root?.let { go(root) }
        return result.elementAt(k)
    }

    private fun go(root: TreeNode) {
        root.left?.let { go(it) }
        result.add(root.`val`)
        root.right?.let { go(it) }
    }
}