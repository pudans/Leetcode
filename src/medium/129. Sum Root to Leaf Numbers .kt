package medium

import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/merge-intervals/
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 */

class Medium129: TreeTopic, BinaryTreeTopic, DFSTopic {

    fun sumNumbers(root: TreeNode?, sum: Int = 0): Int {
        root ?: return 0
        val newSum = sum * 10 + root.`val`
        if (root.left == null && root.right == null) return newSum
        return (root.left?.let { sumNumbers(it, newSum) } ?: 0) +
                (root.right?.let { sumNumbers(it, newSum) } ?: 0)
    }
}