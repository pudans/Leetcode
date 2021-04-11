package medium

import java.util.*
import kotlin.collections.HashMap

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class Solution116 {

    val map = HashMap<Int,Node?>()

    fun connect(root1: Node?): Node? {
        root1?.let { root ->
            go(0, root)
        }

        return root1
    }

    fun go(level: Int, root: Node) {
        val last = map[level]
        if (last != null) {
            map[level]?.next = root
        }
        map[level] = root
        root.left?.let { go(level + 1, it) }
        root.right?.let { go(level + 1, it) }
    }
}