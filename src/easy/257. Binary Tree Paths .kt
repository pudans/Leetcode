package easy

import utils.TreeNode

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 */

class Easy257 {

    val result = ArrayList<String>()

    fun binaryTreePaths(root: TreeNode?): List<String> {
        root ?: return emptyList()
        getPath(root)
        return result
    }

    private fun getPath(root: TreeNode, currentPath: String = "") {
        var newPath = currentPath
        if (currentPath.isNotEmpty()) {
            newPath += "->"
        }
        newPath += root.`val`.toString()
        if (root.left == null && root.right == null) {
            result.add(newPath)
        }
        root.left?.let { getPath(it, newPath) }
        root.right?.let { getPath(it, newPath) }
    }
}