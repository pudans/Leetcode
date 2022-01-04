package easy

import BinarySearchTopic
import BinaryTreeTopic
import TwoPointersTopic
import utils.TreeNode

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
Given the root of a Binary Search Tree and a target number k,
return true if there exist two elements in the BST such that their sum is equal to the given target.
 */

class Easy700 : BinaryTreeTopic, BinarySearchTopic {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return null
        if (root.`val` == `val`) return root
        return if (root.`val` > `val`) searchBST(root.left, `val`)
        else searchBST(root.right, `val`)
    }
}