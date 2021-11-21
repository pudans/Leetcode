package medium

import BinaryTreeTopic
import TreeTopic
import utils.TreeNode

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
BULLSHIT
 */

class Medium106 : TreeTopic, BinaryTreeTopic {

    fun buildTree(
            inorder: IntArray, postorder: IntArray,
            inS: Int = 0, inE: Int = inorder.lastIndex,
            posS: Int = 0, posE: Int = postorder.lastIndex
    ): TreeNode? {
        if (inS > inE || posS > posE) return null
        val root = TreeNode(postorder[posE])
        val rootI = inorder.indexOfFirst { it == root.`val` }
        root.left = buildTree(inorder, postorder,  inS, rootI - 1, posS, posS + rootI - inS - 1)
        root.right = buildTree(inorder, postorder, rootI + 1, inE,posS + rootI - inS, posE - 1)
        return root
    }
}