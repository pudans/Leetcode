package medium

import com.sun.source.tree.Tree
import utils.TreeNode

class Solution236 {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        if (root == p || root == q) {
            return root
        }
        val right = lowestCommonAncestor(root.right, p, q)
        val left = lowestCommonAncestor(root.left, p, q)
        if (right != null && left != null) {
            return root
        }
        return right ?: left
    }

    fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        val listP = findNode(root, p, ArrayList())
        val listQ = findNode(root, q, ArrayList())
        println(listP)
        println(listQ)
        if (listP == null || listQ == null) {
            return null
        }
        for (i in listP.size - 1 downTo 0) {
            for (j in listQ.size - 1 downTo 0) {
                if (listP[i] == listQ[j]) {
                    println("$i $j ${listP[i]}")
                    return listP[i]
                }
            }
        }
        return null
    }

    private fun findNode(root: TreeNode, node: TreeNode, list: ArrayList<TreeNode>): ArrayList<TreeNode>? {
        if (root == node) {
            list.add(node)
            return list
        }
        list.add(root)
        if (root.left != null) {
            val left = findNode(root.left!!, node, list)
            if (left != null) {
                return left
            }
        }
        if (root.right != null) {
            val right = findNode(root.right!!, node, list)
            if (right != null) {
                return right
            }
        }
        list.removeAt(list.size - 1)
        return null
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(3)
            root.right = TreeNode(1)
            root.right?.right = TreeNode(8)
            root.right?.left = TreeNode(0)
            root.left = TreeNode(5)
            root.left?.right = TreeNode(2)
            root.left?.left = TreeNode(6)
            root.left?.right?.right = TreeNode(4)
            root.left?.right?.left = TreeNode(7)

            println(Solution236().lowestCommonAncestor(root, TreeNode(5), TreeNode(4)))
        }
    }
}