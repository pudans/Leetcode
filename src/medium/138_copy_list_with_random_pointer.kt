package medium

import java.util.*


class Solution138 {

    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return head
        }
        val m = HashMap<Node, Node?>()
        var cur = head
        val ans = Node(0)
        var cur1: Node? = ans
        while (cur != null) {
            cur1?.`val` = cur.`val`
            m[cur] = cur1
            val temp = Node(0)
            cur1?.next = temp
            cur1 = cur1?.next
            cur = cur.next
        }
        cur = head
        cur1 = ans
        var cur2 = cur1
        while (cur != null) {
            cur2 = cur1
            val temp = m[cur.random]
            cur1?.random = temp
            cur = cur.next
            cur1 = cur1!!.next
        }
        cur2!!.next = null
        return ans
    }

    fun copyRandomList1(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val newHead = node
        var temp = node
        var tempNew = Node(newHead.`val`).apply {
            random = newHead.random
        }

        while (temp != null) {
            val copy = Node(temp.`val`).apply {
                random = temp?.random
            }
            tempNew.next = copy
            copy.next = temp.next
            temp = temp.next
        }

        log(node)

//        val newHead = node?.next

        var parent = node
        temp = newHead
        var i = 0
        while (temp != null) {
            temp.random = parent?.random?.next
            parent = temp.next
            temp.next = parent?.next
            temp = temp.next
        }
        node?.next = node?.next?.next

        log(node)
        log(newHead)

        return newHead
    }

    private fun log(head: Node?) {
        println()
        var temp = head
        while (temp != null) {
            print(", ${temp.str()}")
            temp = temp.next
        }
    }

    fun Node.str(): String {
        return "${`val`}${hashCode()}[n=${next?.hashCode()}},r=${random?.hashCode()}}]"
    }

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }
}