package medium

import utils.TreeNode

class Solution114 {

    val list = ArrayList<TreeNode>()

    fun flatten(root: TreeNode?): Unit {
        root?.let {  preOrder(it) }
        for (i in 1 until list.size) {
            list[i - 1].left = null
            list[i - 1].right = list[i]
        }
    }

    fun preOrder(node: TreeNode) {
        list.add(node)
        print("${node.`val`} ")
        node.left?.let { preOrder(it) }
        node.right?.let { preOrder(it) }
    }
}