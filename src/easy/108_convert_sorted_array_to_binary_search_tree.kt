package easy

import utils.TreeNode

class Solution108 {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        return createBalancedTree(nums, 0, nums.size - 1)
    }

    private fun createBalancedTree(array: IntArray, start: Int, end: Int): TreeNode? {
        if (end < start) {
            return null
        }
        val middle = ((start + end) / 2f).toInt()
        val node = TreeNode(array[middle])
        node.left = createBalancedTree(array, start, middle - 1)
        node.right = createBalancedTree(array, middle + 1, end)
        return node
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val data = intArrayOf(-10,-3,0,5,9)
            val tree = Solution108().sortedArrayToBST(data)!!
            Tree.Traversal.LevelOrder.traverse(tree)
            println(Tree.Traversal.LevelOrder.result)
        }
    }
}