package medium

import utils.TreeNode

class Solution102 {

    private val result = ArrayList<ArrayList<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return result
        }

        val dd = ArrayList<Int>(1)
        dd.add(root.`val`)
        result.add(dd)

        root.left?.let { traverse(1, it) }
        root.right?.let { traverse(1, it) }

        return result
    }

    fun traverse(level: Int, root: TreeNode) {
        val dd = result.getOrElse(level) { ArrayList(level * 2) }
        dd.add(root.`val`)
        if (result.size <= level) {
            result.add(dd)
        } else {
            result[level] = dd
        }

        root.left?.let { traverse(level + 1, it) }
        root.right?.let { traverse(level + 1, it) }

    }
}