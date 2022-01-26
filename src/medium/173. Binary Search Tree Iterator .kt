package medium

import BinarySearchTopic
import BinaryTreeTopic
import StackTopic
import utils.TreeNode

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor.
The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 */

class Medium173 : BinaryTreeTopic, BinarySearchTopic, StackTopic {

    class BSTIterator(root: TreeNode?) {

        private var pos = -1
        private val nodes = mutableListOf<Int>()

        init {
            traverse(root)
        }

        private fun traverse(root: TreeNode?) {
            root ?: return
            traverse(root.left)
            nodes.add(root.`val`)
            traverse(root.right)
        }

        fun next(): Int = nodes.getOrNull(++pos) ?: 0

        fun hasNext(): Boolean = pos < nodes.lastIndex
    }
}