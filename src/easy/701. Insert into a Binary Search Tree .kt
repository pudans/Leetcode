package easy

import BinarySearchTopic
import BinaryTreeTopic
import utils.TreeNode

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */

class Easy701 : BinaryTreeTopic, BinarySearchTopic {

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return TreeNode(`val`)
        if (`val` > root.`val`) {
            if (root.right == null) {
                root.right = TreeNode(`val`)
            } else {
                insertIntoBST(root.right, `val`)
            }
        } else {
            if (root.left == null) {
                root.left = TreeNode(`val`)
            } else {
                insertIntoBST(root.left, `val`)
            }
        }
        return root
    }
}