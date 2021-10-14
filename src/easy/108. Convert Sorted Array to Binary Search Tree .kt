package easy

import utils.TreeNode

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

class Easy108 {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return createBalancedTree(nums, 0, nums.size - 1)
    }

    private fun createBalancedTree(array: IntArray, start: Int, end: Int): TreeNode? {
        if (end < start) return null
        val middle = ((start + end) / 2f).toInt()
        val node = TreeNode(array[middle])
        node.left = createBalancedTree(array, start, middle - 1)
        node.right = createBalancedTree(array, middle + 1, end)
        return node
    }
}

fun main() {
    val data = intArrayOf(-10,-3,0,5,9)
    val tree = Easy108().sortedArrayToBST(data)!!
    Tree.Traversal.LevelOrder.traverse(tree)
    println(Tree.Traversal.LevelOrder.result)
}