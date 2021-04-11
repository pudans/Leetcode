package easy

import utils.TreeNode

class Solution404 {

    var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        calculate(root)
        return sum
    }

    fun calculate(root: TreeNode?) {
        root?.let { root ->
            root.left?.let {
                if (it.left == null && it.right == null) {
                    sum += it.`val`
                } else {
                    calculate(it)
                }
            }
            root.right?.let {
                calculate(it)
            }
        }
    }
}