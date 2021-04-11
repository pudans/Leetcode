package medium

import utils.TreeNode

class Solution103 {

    // [3,9,20,99,88,15,7,1,2,3,4,5,6,7,8]

    val result = ArrayList<ArrayList<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root?.let { traverse(root) }
        for (i in result.indices) {
            if (i % 2 == 0) {
                result[i] = ArrayList(result[i].reversed())
            }
        }
        return result
    }

    fun traverse(root: TreeNode, level: Int = 0) {
        val dd = result.getOrElse(level) { ArrayList(level * 2) }
        dd.add(root.`val`)
        if (result.size <= level) result.add(dd) else result[level] = dd

        root.left?.let { traverse(it, level + 1) }
        root.right?.let { traverse(it, level + 1) }
    }


//    private val result = ArrayList<ArrayList<Int>>()
//
//    fun levelOrder(root: TreeNode?): List<List<Int>> {
//        if (root == null) {
//            return result
//        }
//
//        val dd = ArrayList<Int>(1)
//        dd.add(root.`val`)
//        result.add(dd)
//
//        root.right?.let { traverse(1, it) }
//        root.left?.let { traverse(1, it) }
//
//        return result
//    }
//
//    fun traverse(level: Int, root: TreeNode) {
//        val dd = result.getOrElse(level) { ArrayList(level * 2) }
//        dd.add(root.`val`)
//        if (result.size <= level) {
//            result.add(dd)
//        } else {
//            result[level] = dd
//        }
//
//        if (level % 2 == 0) {
//            root.left?.let { traverse(level + 1, it) }
//            root.right?.let { traverse(level + 1, it) }
//        } else {
//            root.right?.let { traverse(level + 1, it) }
//            root.left?.let { traverse(level + 1, it) }
//        }
//    }
}