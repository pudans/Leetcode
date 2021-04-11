package easy

import utils.TreeNode


class Solution534 {

    var result = 1

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return result - 1
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        } else {
            val leftDepth = depth(root.left)
            val rightDepth = depth(root.right)

            result = Math.max(result, leftDepth + rightDepth + 1)

            return Math.max(rightDepth, leftDepth) + 1
        }
    }
}