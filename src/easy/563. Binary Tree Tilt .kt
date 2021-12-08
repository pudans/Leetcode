package easy

import BFSTopic
import BinaryTreeTopic
import LinkedListTopic
import MathTopic
import StringTopic
import TreeTopic
import TwoPointersTopic
import utils.ListNode
import utils.TreeNode
import java.lang.StringBuilder

/**
 * 563. Binary Tree Tilt
 * https://leetcode.com/problems/binary-tree-tilt/
 *
Given the root of a binary tree, return the sum of every tree node's tilt.
The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
The rule is similar if there the node does not have a right child.
 */

class Easy563: TreeTopic, BFSTopic, BinaryTreeTopic {

    var result = 0

    fun findTilt(root: TreeNode?): Int {
        tiltAndReturnSum(root)
        return result
    }

    private fun tiltAndReturnSum(root: TreeNode?): Int {
        root ?: return 0
        val leftSum = tiltAndReturnSum(root.left)
        val rightSum = tiltAndReturnSum(root.right)
        result += Math.abs(leftSum - rightSum)
        return root.`val` + leftSum + rightSum
    }
}