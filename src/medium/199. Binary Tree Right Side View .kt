package medium

import BFSTopic
import BinaryTreeTopic
import DFSTopic
import utils.TreeNode

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */

class Medium199 : BinaryTreeTopic, BFSTopic, DFSTopic {

    fun rightSideView(root: TreeNode?, level: Int = 0, result: MutableList<Int> = mutableListOf()): List<Int> {
        root ?: return result
        if (result.size <= level) {
            result.add(root.`val`)
        } else {
            result[level] = root.`val`
        }

        root.left?.let { rightSideView(it, level + 1, result) }
        root.right?.let { rightSideView(it, level + 1, result) }

        return result
    }
}