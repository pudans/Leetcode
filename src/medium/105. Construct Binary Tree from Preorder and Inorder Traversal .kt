package medium

import BinaryTreeTopic
import TreeTopic
import utils.TreeNode

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * BULLSHIT
 */

class Medium105 : TreeTopic, BinaryTreeTopic {

    fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
        start: Int = 0,
        end: Int = inorder.lastIndex,
        index: Int = 0
    ): TreeNode? {
        if (start > end) return null
        val root = TreeNode(preorder[index])
        var inIndex = start
        while (preorder[index] != inorder[inIndex]) inIndex++
        root.left = buildTree(preorder, inorder, start, inIndex - 1, index + 1)
        root.right = buildTree(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1)
        return root
    }
}