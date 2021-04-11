package easy

import utils.ListNode

class Solution203 {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var newHead = head
        while (newHead?.`val` == `val`) {
            newHead = newHead.next
        }
        var temp = newHead
        while (temp != null) {
            if (temp.next?.`val` == `val`) {
                temp.next = temp.next?.next
            } else {
                temp = temp.next
            }
        }
        return newHead
    }
}