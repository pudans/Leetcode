package medium

import utils.TreeNode

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */

class Medium199 {

    private val result = ArrayList<Int>()

    fun rightSideView(root: TreeNode?): List<Int> {
        root?.let { traverse(it) }
        return result
    }

    fun traverse(root: TreeNode, level: Int = 0) {

        if (result.size <= level) {
            result.add(root.`val`)
        } else {
            result.set(level, root.`val`)
        }

        root.left?.let { traverse(it, level + 1) }
        root.right?.let { traverse(it, level + 1) }
    }
}