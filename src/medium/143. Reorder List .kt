package medium

import LinkedListTopic
import StackTopic
import TwoPointersTopic
import utils.ListNode
import utils.add
import utils.toStringList


/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 BULLSHIT
 */

class Medium143 : LinkedListTopic, TwoPointersTopic, StackTopic {

    fun midNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast!!.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }
        return slow
    }

    fun reverse(head: ListNode?): ListNode? {
        var curr = head
        var prev: ListNode? = null
        var next: ListNode? = null
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }


    fun reorderList(head: ListNode?) {
        val midNode = midNode(head)
        val nextToMid = midNode!!.next
        midNode.next = null
        val rev = reverse(nextToMid)
        var p1 = head
        var p2 = rev
        var p1Next: ListNode?
        while (p1 != null && p2 != null) {
            p1Next = p1.next
            p1.next = p2
            p1 = p2
            p2 = p1Next
        }
    }
}

fun main() {
    val list = ListNode(1)
    list.add(2).add(3).add(4).add(5)
    println(list.toStringList())
    Medium143().reorderList(list)
    println("end")
    println(list.toStringList())
}