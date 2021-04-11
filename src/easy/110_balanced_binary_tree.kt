package easy

import utils.TreeNode

class Solution110 {

    fun isBalanced(root: TreeNode?): Boolean {

        if (root == null) {
            return true
        } else {
            return Math.abs(
                    getHeight(root.left, 0) -
                    getHeight(root.right, 0)
            ) <= 1 && isBalanced(root.right) && isBalanced(root.left)
        }
    }

    fun getHeight(root: TreeNode?, currentHeight: Int): Int {
        if (root == null) {
            return currentHeight
        } else {
            return Math.max(
                    getHeight(root.right, currentHeight + 1),
                    getHeight(root.left, currentHeight + 1)
            )
        }
    }
}