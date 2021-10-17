package easy

import TreeTopic
import utils.TreeNode

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

class Easy100: TreeTopic {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p != null && q == null) return false
        if (q != null && p == null) return false
        if (p?.`val` != q?.`val`) return false
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}