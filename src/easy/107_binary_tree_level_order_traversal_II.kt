package easy

import utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

data class Data(val root: TreeNode?, val level: Int)

class Solution107 {

    val queue = LinkedList<Data>()

    fun levelOrderBottom(root: TreeNode?): List<List<Int>>? {

        val result = ArrayList<ArrayList<Int>>()

        queue.addLast(Data(root,0))
        while (queue.isNotEmpty()) {

            val data = queue.removeFirst()
            if (data.root != null) {
                result.getOrNull(data.level)?.let {
                    it.add(data.root.`val`)
                    result[data.level] = it
                } ?: kotlin.run {
                    val list = ArrayList<Int>()
                    list.add(data.root.`val`)
                    result.add(list)
                }

                queue.addLast(Data(data.root.left, data.level + 1))
                queue.addLast(Data(data.root.right, data.level + 1))
            }
        }

        return result.reversed()
    }
}