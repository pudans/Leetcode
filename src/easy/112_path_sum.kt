package easy

import utils.TreeNode

class Solution112 {

    var findingSum = 0

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        findingSum = sum
        if (root == null) {
            return false
        }
        return isPathSum(root, 0)
    }

    fun isPathSum(root: TreeNode, currentSum: Int): Boolean {

        val newSum = currentSum + root.`val`

        if (root.left == null && root.right == null) {
            return newSum == findingSum
        } else if (root.left != null && root.right != null) {
            val res =
                    isPathSum(root.right!!, newSum) ||
                    isPathSum(root.left!!, newSum)
            println("${root.`val`} $res")
            return res
        } else if (root.left != null) {
            return isPathSum(root.left!!, newSum)
        } else {
            return isPathSum(root.right!!, newSum)
        }
    }
}