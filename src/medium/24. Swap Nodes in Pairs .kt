package medium

import LinkedListTopic
import utils.ListNode

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

class Medium24 : LinkedListTopic {

    fun swapPairs(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return head
        val sentinel = ListNode(0)
        sentinel.next = head
        var step = sentinel
        while (true) {
            val temp1 = step.next ?: break
            val temp2 = step.next?.next ?: break
            step.next = temp2
            temp1.next = temp2.next
            temp2.next = temp1
            step = temp1
        }
        return sentinel.next
    }
}