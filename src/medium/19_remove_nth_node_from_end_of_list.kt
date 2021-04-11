package medium

import utils.ListNode

class Solution19 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = ArrayList<ListNode>()

        var temp = head
        while (temp != null) {
            list.add(temp)
            temp = temp.next
        }

        if (n == list.size) {
            return head?.next
        } else {

            val dd = list[list.size - (n + 1)]
            dd.next = dd.next?.next

            return head
        }
    }
}