package easy

import utils.TreeNode

class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        swap(root)

        return root;
    }

    fun swap(root: TreeNode?) {
        val temp = root?.left

        root?.left = root?.right
        root?.right = temp

        root?.left?.let {
            swap(it);
        }
        root?.right?.let {
            swap(it);
        }
    }
}