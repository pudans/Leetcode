package medium

import utils.TreeNode
import java.util.*

class Solution230 {

    private val result = TreeSet<Int>()

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        root?.let { go(root) }
        return result.elementAt(k)
    }

    fun go(root: TreeNode) {
        root.left?.let { go(it) }
        result.add(root.`val`)
        root.right?.let { go(it) }
    }
}