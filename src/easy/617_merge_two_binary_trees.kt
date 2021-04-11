package easy

import utils.TreeNode

class Solution617 {

    class Solution {
        fun mergeTrees(first: TreeNode?, second: TreeNode?): TreeNode? {

            if (first == null && second == null) {
                return null
            }

            if (first == null) {
                return second
            }

            if (second == null) {
                return first
            }

            mergeTrees11(first, second)

            return first
        }

        fun mergeTrees11(first: TreeNode, second: TreeNode) {
            first.`val` += second.`val`
            if (first.left != null && second.left != null) {
                mergeTrees11(first.left!!, second.left!!)
            } else if (first.left == null && second.left != null) {
                first.left = second.left
            }

            if (first.right != null && second.right != null) {
                mergeTrees11(first.right!!, second.right!!)
            } else if (first.right == null && second.right != null) {
                first.right = second.right
            }
        }
    }
}