package medium

import BFSTopic
import BinaryTreeTopic
import TreeTopic
import utils.TreeNode

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/next-permutation/
 *
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */

class Medium1026 : TreeTopic, BinaryTreeTopic, BFSTopic {

    fun maxAncestorDiff(root: TreeNode?, min: Int = Int.MAX_VALUE, max: Int = 0): Int {
        root ?: return 0
        return maxOf(
            maxOf(root.`val` - min, max - root.`val`),
            maxAncestorDiff(root.left, minOf(root.`val`, min), maxOf(max, root.`val`)),
            maxAncestorDiff(root.right, minOf(root.`val`, min), maxOf(max, root.`val`))
        )
    }
}