package medium

import HashTableTopic
import LinkedListTopic

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */

class Medium138 : HashTableTopic, LinkedListTopic {

    fun copyRandomList(head: Node?): Node? {
        head ?: return null
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