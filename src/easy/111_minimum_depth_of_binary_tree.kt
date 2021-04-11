package easy

import utils.TreeNode

class Solution111 {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return getHeight(root, 0) + 1
    }

    fun getHeight(root: TreeNode, currentHeight: Int): Int {

        if (root.left == null && root.right == null) {
            return currentHeight
        } else if (root.left != null && root.right != null) {
            val res = Math.min(
                    getHeight(root.right!!, currentHeight + 1),
                    getHeight(root.left!!, currentHeight + 1)
            )
            println("${root.`val`} $res")
            return res
        } else if (root.left != null) {
            return getHeight(root.left!!, currentHeight + 1)
        } else {
            return getHeight(root.right!!, currentHeight + 1)
        }
    }
}