package medium

import BinaryTreeTopic
import DFSTopic
import DynamicProgrammingTopic
import TreeTopic
import utils.TreeNode


/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree.
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 */

class Medium337 : DynamicProgrammingTopic, TreeTopic, DFSTopic, BinaryTreeTopic {

    val map = HashMap<TreeNode, Int>()

    fun rob(root: TreeNode?): Int {
        if (root == null) return 0
        var max = 0
        map[root]?.let { return it }
        if (root.left != null) max += rob(root.left!!.left) + rob(root.left!!.right)
        if (root.right != null) max += rob(root.right!!.left) + rob(root.right!!.right)
        max = maxOf(max + root.`val`, rob(root.left) + rob(root.right))
        map[root] = max
        return max
    }

    fun rob(root: TreeNode?, canRob: Boolean = true): Int {
        if (root == null) return 0
        return when (canRob) {
            true -> maxOf(
                rob(root.right) + rob(root.left),
                root.`val` + rob(root.right, false) + rob(root.left, false)
            )
            false -> rob(root.right) + rob(root.left)
        }
    }
}