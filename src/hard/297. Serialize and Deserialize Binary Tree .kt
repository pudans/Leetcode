package hard

import BFSTopic
import BinaryTreeTopic
import DFSTopic
import TreeTopic
import utils.TreeNode
import java.util.*


/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.
For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z',
your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.
Implement the StreamChecker class:
StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.

BULLSHIT
 */

class Hard297 : TreeTopic, BinaryTreeTopic, BFSTopic, DFSTopic {

    class Codec() {
        // Encodes a tree to a single string.
        fun serialize(root: TreeNode?): String {
            val result = mutableListOf<Int>()
            val queue = LinkedList<TreeNode?>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                if (node != null) {
                    result.add(node.`val`)
                    queue.add(node.left)
                    queue.add(node.right)
                } else {
                    result.add(-2000)
                }
            }
            return result.joinToString(",") { if (it == -2000) "null" else it.toString() }
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            val arr = data.split(",")
            val qTree: Queue<TreeNode?> = LinkedList()
            var i = 0
            val value = if (i < arr.size) arr[i++] else null
            if ("null" == value || value == null) {
                return null
            }
            val root = TreeNode(value.toInt())
            qTree.add(root)
            while (!qTree.isEmpty() && i < arr.size) {
                val prev = qTree.poll()
                val left = if (i < arr.size) arr[i++] else null
                val right = if (i < arr.size) arr[i++] else null
                if ("null" != left) {
                    prev!!.left = TreeNode(left!!.toInt())
                    qTree.add(prev.left)
                }
                if ("null" != right) {
                    prev!!.right = TreeNode(right!!.toInt())
                    qTree.add(prev.right)
                }
            }
            return root
        }
    }
}