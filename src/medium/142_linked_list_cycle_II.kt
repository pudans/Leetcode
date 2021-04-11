package medium

import utils.ListNode

class Solution142 {

    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        var fast = head
        var slow = head
        while (fast != null) {
            if (fast.next == null || fast.next!!.next == null) {
                return null
            }
            slow = slow!!.next
            fast = fast.next!!.next
            if (fast === slow) break
        }
        fast = head
        while (fast !== slow) {
            fast = fast!!.next
            slow = slow!!.next
        }
        return slow
    }
}