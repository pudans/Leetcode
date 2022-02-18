package easy

import BacktrackingTopic
import utils.TreeNode

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 */

class Easy257 : BacktrackingTopic {

    fun binaryTreePaths(
        root: TreeNode?,
        currentPath: String = "",
        result: ArrayList<String> = ArrayList()
    ): List<String> {
        root ?: return emptyList()
        var newPath = currentPath
        if (currentPath.isNotEmpty()) {
            newPath += "->"
        }
        newPath += root.`val`.toString()
        if (root.left == null && root.right == null) {
            result.add(newPath)
        }
        root.left?.let { binaryTreePaths(it, newPath, result) }
        root.right?.let { binaryTreePaths(it, newPath, result) }
        return result
    }
}