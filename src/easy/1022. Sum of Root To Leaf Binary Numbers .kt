package easy

import BinaryTreeTopic
import DFSTopic
import utils.TreeNode

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
The test cases are generated so that the answer fits in a 32-bits integer.
 */

class Easy1022 : BinaryTreeTopic, DFSTopic {

    fun sumRootToLeaf(root: TreeNode?, list: MutableList<Int> = mutableListOf()): Int {
        root ?: return 0
        list.add(root.`val`)
        return if (root.right == null && root.left == null) {
            list.joinToString("").toInt(2)
        } else {
            sumRootToLeaf(root.left, ArrayList(list)) + sumRootToLeaf(root.right, ArrayList(list))
        }
    }
}