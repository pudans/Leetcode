package easy

import utils.TreeNode

class Solution104 {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}