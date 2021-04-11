package easy

import utils.TreeNode

class Solution257 {

    val result = ArrayList<String>()
    fun binaryTreePaths(root: TreeNode?): List<String> {

        if (root != null) {
            getPath(root, "")
        }
        return result
    }

    fun getPath(root: TreeNode, currentPath: String) {
        var newPath = currentPath
        if (currentPath.isNotEmpty()) {
            newPath += "->"
        }
        newPath += root.`val`.toString()
        if (root.left == null && root.right == null) {

            result.add(newPath)
        }
        if (root.left != null) {
            getPath(root.left!!, newPath)
        }
        if (root.right != null) {
            getPath(root.right!!, newPath)
        }
    }
}