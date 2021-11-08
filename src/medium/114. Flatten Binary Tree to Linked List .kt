package medium

import utils.TreeNode

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

class Medium114 {

    val list = ArrayList<TreeNode>()

    fun flatten(node: TreeNode?): Unit {
        node ?: return
        list.lastOrNull()?.right = node
        list.lastOrNull()?.left = null
        list.add(node)
        val right = node.right
        node.left?.let { flatten(it) }
        right?.let { flatten(it) }
    }
}