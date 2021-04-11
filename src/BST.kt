import utils.TreeNode

object BST {

    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBST(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) return false
        return isValidBST(node.left, min, node.`val`.toLong()) && isValidBST(node.right, node.`val`.toLong(), max)
    }
}