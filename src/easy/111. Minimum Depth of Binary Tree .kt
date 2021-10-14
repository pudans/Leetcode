package easy

import utils.TreeNode

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */

class Easy111 {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return getHeight(root) + 1
    }

    private fun getHeight(root: TreeNode, currentHeight: Int = 0): Int =
        when {
            root.left == null && root.right == null -> currentHeight
            root.left != null && root.right != null ->
                Math.min(
                    getHeight(root.right!!, currentHeight + 1),
                    getHeight(root.left!!, currentHeight + 1)
                )
            root.left != null -> getHeight(root.left!!, currentHeight + 1)
            else -> getHeight(root.right!!, currentHeight + 1)
        }
}