package medium

import BinarySearchTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 */

class Medium222: BinarySearchTopic, TreeTopic, BinaryTreeTopic, DFSTopic {

    fun countNodes(root: TreeNode?): Int {
        root ?: return 0
        return countNodes(root.left) + countNodes(root.right) + 1
    }
}