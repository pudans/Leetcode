package easy

import utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
 * return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 */

class Easy993 {

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        root ?: return false
        var xi = 0
        var yi = 0

        val list = ArrayList<Int>()

        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val value = node?.`val` ?: -1
            if (value == x) xi = list.size
            if (value == y) yi = list.size
            if (xi != 0 && yi != 0) break
            list.add(value)
            if (node != null) {
                queue.add(node.left)
                queue.add(node.right)
            }
        }

        println(xi)
        println(yi)

        return when {

            xi >= 63 + 32 -> yi >= 63 && yi < 63 + 32
            xi >= 63 -> yi >= 63 + 32

            xi >= 31 + 16 -> yi >= 31 && yi < 31 + 16
            xi >= 31 -> yi >= 31 + 16

            xi >= 14 + 8 -> yi >= 14 && yi < 14 + 8
            xi >= 14 -> yi >= 14 + 8

            xi >= 7 + 4 -> yi >= 7 && yi < 7 + 4
            xi >= 7 -> yi >= 7 + 4

            xi >= 3 + 2 -> yi >= 3 && yi < 3 + 2
            xi >= 3 -> yi >= 3 + 2

            else -> return false
        }
    }
}