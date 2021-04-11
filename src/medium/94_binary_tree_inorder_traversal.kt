package medium

import utils.TreeNode

class Solution94 {

    val result = ArrayList<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let { go(it) }
        return result
    }

    fun go(root: TreeNode) {
        root.left?.let { go(it) }
        result.add(root.`val`)
        root.right?.let { go(it) }
    }
}