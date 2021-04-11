package medium

import utils.TreeNode
import java.util.ArrayList

class Solution337 {

    fun rob(root: TreeNode?, canRob: Boolean = true): Int {
        if (root == null) return 0
        if (!canRob) {
            return rob(root.right) + rob(root.left)
        } else {
            return Math.max(
                rob(root.right) + rob(root.left),
                root.`val` + rob(root.right, false) + rob(root.left, false)
            )
        }
    }
}