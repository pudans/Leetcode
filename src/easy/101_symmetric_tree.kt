package easy

import utils.TreeNode
import java.util.*

class Solution101 {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null || (root.right == null && root.left == null)) {
            return true
        }

        if (root.right?.`val` != root.left?.`val`) {
            return false
        }

        val stack1 = Stack<TreeNode>()
        stack1.push(root.left)
        val stack2 = Stack<TreeNode>()
        stack2.push(root.right)

        while (stack1.isNotEmpty() && stack2.isNotEmpty()) {
            val t1 = stack1.pop()
            val t2 = stack2.pop()
            if (t1.`val` != t2.`val`) {
                return false
            } else {
                if (t1.left?.`val` == t2.right?.`val` && t1.left != null) {
                    stack1.push(t1.left)
                    stack2.push(t2.right)
                } else if (t1.left == null && t2.right == null) {

                } else  {
                    return false
                }
                if (t1.right?.`val` == t2.left?.`val` && t1.right != null) {
                    stack1.push(t1.right)
                    stack2.push(t2.left)
                } else if (t1.right == null && t2.left == null) {

                } else  {
                    return false
                }
            }
        }

        return true
    }
}