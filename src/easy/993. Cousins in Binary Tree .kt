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
        val left = findLevel(root, x) ?: return false
        val right = findLevel(root, y) ?: return false
        if (left.size == right.size) {
            if (left.size <= 1) return false
            if (left.last() == right.last()) return false
            for (i in (left.size - 2) downTo 0) {
                if (left[i] == right[i]) return true
            }
        }
        return false
    }

    private fun findLevel(node: TreeNode?, target: Int, list: List<Int> = emptyList()): List<Int>? =
        when {
            node == null -> null
            node.`val` == target -> list
            else -> {
                val newArray = ArrayList(list).also { it.add(node.`val`) }
                findLevel(node.left, target, newArray) ?: findLevel(node.right, target, newArray)
            }
        }
}