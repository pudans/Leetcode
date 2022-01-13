package easy

import LinkedListTopic
import utils.ListNode
import utils.toStringList

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class Easy206 : LinkedListTopic {

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        return prev
    }
}

fun main() {
    println(
        Easy206().reverseList(
            ListNode.create(ListNode(1), ListNode(2), ListNode(4))
        ).toStringList()
    )
}