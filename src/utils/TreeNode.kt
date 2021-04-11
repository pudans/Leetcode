package utils

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String = `val`.toString()

    override fun equals(other: Any?): Boolean = other is TreeNode && other.`val` == this.`val`
}