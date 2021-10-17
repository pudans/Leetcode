package easy

import utils.ListNode

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class Easy206 {

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