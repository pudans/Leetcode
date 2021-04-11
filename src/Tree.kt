import utils.TreeNode
import java.util.*


/**
 * https://medium.com/@dimko1/%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%8B-%D0%BE%D0%B1%D1%85%D0%BE%D0%B4-%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%B0-ed54848c2d47
 */

object Tree {

    class Node(var data: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String = data.toString()
    }

    object Traversal {

        object DFS {

            fun preOrder(node: TreeNode) {
                print("${node.`val`} ")
                node.left?.let { preOrder(it) }
                node.right?.let { preOrder(it) }
            }

            fun inOrder(node: TreeNode) {
                node.left?.let { inOrder(it) }
                print("${node.`val`} ")
                node.right?.let { inOrder(it) }
            }

            fun postOrder(node: TreeNode) {
                node.left?.let { postOrder(it) }
                node.right?.let { postOrder(it) }
                print("${node.`val`} ")
            }
        }

        object BFS {

            fun traverse(head: TreeNode) {
                val queue: Queue<TreeNode> = LinkedList()
                queue.add(head)
                while (queue.isNotEmpty()) {
                    val node = queue.poll()
                    print("${node.`val`} ")
                    node.left?.let { queue.add(it) }
                    node.right?.let { queue.add(it) }
                }
            }
        }

        object LevelOrder {

            val result = ArrayList<ArrayList<Int>>()

            fun traverse(root: TreeNode, level: Int = 0) {
                val dd = result.getOrElse(level) { ArrayList(level * 2) }
                dd.add(root.`val`)
                if (result.size <= level) result.add(dd) else result[level] = dd

                root.left?.let { traverse(it, level + 1) }
                root.right?.let { traverse(it, level + 1) }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val tree = TreeNode(10)
        tree.left = TreeNode(5)
        tree.left?.left = TreeNode(3)
        tree.left?.left?.left = TreeNode(2)
        tree.left?.left?.right = TreeNode(5)
        tree.left?.right = TreeNode(7)
        tree.left?.right?.left = TreeNode(7)

        tree.right = TreeNode(35)
        tree.right?.left = TreeNode(23)
        tree.right?.right = TreeNode(94)

        Traversal.DFS.preOrder(tree)
        println()
        Traversal.DFS.inOrder(tree)
        println()
        Traversal.DFS.postOrder(tree)
        println()
        Traversal.BFS.traverse(tree)
        println()
        Traversal.LevelOrder.traverse(tree)
        println(Traversal.LevelOrder.result)
    }
}