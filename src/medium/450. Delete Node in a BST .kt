package medium

import BinarySearchTopic
import BinaryTreeTopic
import utils.TreeNode

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
 BULLSHIT
 */

class Medium450 : BinarySearchTopic, BinaryTreeTopic {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        when {
            root == null -> return null
            root.`val` > key -> root.left = deleteNode(root.left, key)
            root.`val` < key -> root.right = deleteNode(root.right, key)
            root.left == null -> return root.right
            root.right == null -> return root.left
            else -> {
                var node = root.right
                while (node!!.left != null) node = node.left
                root.`val` = node.`val`
                root.right = deleteNode(root.right, root.`val`)
            }
        }
        return root
    }
}