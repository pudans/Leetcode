package easy

import ArraysTopic
import BinarySearchTopic
import BinaryTreeTopic
import Tree
import TreeTopic
import utils.TreeNode

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

class Easy108 : ArraysTopic, TreeTopic, BinaryTreeTopic, BinarySearchTopic {

    fun sortedArrayToBST(nums: IntArray, start: Int = 0, end: Int = nums.lastIndex): TreeNode? {
        if (nums.isEmpty()) return null
        if (end < start) return null
        val middle = (start + end) / 2
        return TreeNode(nums[middle]).apply {
            left = sortedArrayToBST(nums, start, middle - 1)
            right = sortedArrayToBST(nums, middle + 1, end)
        }
    }
}

fun main() {
    val data = intArrayOf(-10, -3, 0, 5, 9)
    val tree = Easy108().sortedArrayToBST(data)!!
    Tree.Traversal.LevelOrder.traverse(tree)
    println(Tree.Traversal.LevelOrder.result)
}