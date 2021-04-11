package medium

import utils.TreeNode
import java.util.ArrayList

class Solution199 {

    val result = ArrayList<Int>()

    fun rightSideView(root: TreeNode?): List<Int> {

        root?.let { traverse(it) }
        return result
    }

    fun traverse(root: TreeNode, level: Int = 0) {

        if (result.size <= level) {
            result.add(root.`val`)
        } else {
            result.set(level, root.`val`)
        }

        root.left?.let { traverse(it, level + 1) }
        root.right?.let { traverse(it, level + 1) }
    }
}