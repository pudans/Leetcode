package medium

import BFSTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes are also counted into the length calculation.
It is guaranteed that the answer will in the range of 32-bit signed integer.
 */

class Medium662 : TreeTopic, DFSTopic, BFSTopic, BinaryTreeTopic {

    var max = 0

    fun widthOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        traverse(root)
        return max
    }

    fun traverse(root: TreeNode, level: Int = 0, pos: Int = 1, list: ArrayList<Int> = ArrayList()) {
        if (level == list.size) {
            list.add(pos)
        }
        max = maxOf(max, pos - list[level] + 1);
        root.left?.let { traverse(it, level + 1, pos * 2) }
        root.right?.let { traverse(it, level + 1, pos * 2 + 1) }
    }
}