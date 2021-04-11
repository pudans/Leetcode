package easy

import utils.ListNode

class Solution876 {

    fun middleNode(head: ListNode?): ListNode? {

        var temp = head
        var result = head
        var i = 0

        while (temp != null) {
            temp = temp.next

            if (i % 2 == 0 && temp != null) {
                result = result?.next
            }
            i++
        }
        return result
    }
}