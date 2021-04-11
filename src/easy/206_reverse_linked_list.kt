package easy

import utils.ListNode

class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            return head
        }
        var prev: ListNode? = null
        var current: ListNode? = head
        while (current != null) {
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        return prev
    }
}