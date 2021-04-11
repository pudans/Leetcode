package medium

import utils.TreeNode

class Solution105 {

    /**
     * ITS SHIT
     */

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTree(preorder, inorder, 0, inorder.size - 1, 0)
    }

    private fun buildTree(preorder: IntArray, inorder: IntArray, start: Int, end: Int, index: Int): TreeNode? {
        if (start > end) return null
        val root = TreeNode(preorder[index])
        var inIndex = start
        while (preorder[index] != inorder[inIndex]) inIndex++
        root.left = buildTree(preorder, inorder, start, inIndex - 1, index + 1)
        root.right = buildTree(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1)
        return root
    }
}