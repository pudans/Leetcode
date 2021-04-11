package easy

import utils.ListNode


class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        if (head.next == null || head.next!!.next == null) {
            return false
        }
        if (head === head.next) {
            return true
        }
        var t1 = head
        var t2 = head.next!!.next
        while (true) {
            if (t1 === t2) {
                return true
            } else {
                if (t2!!.next != null && t2.next!!.next != null) {
                    t1 = t1!!.next
                    t2 = t2.next!!.next
                } else {
                    return false
                }
            }
        }
    }
}