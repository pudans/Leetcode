package easy

import utils.ListNode

class Solution83 {

    fun deleteDuplicates(head: ListNode?): ListNode? {

        var currentNode = head
        while (currentNode != null) {
            if (currentNode.`val` == currentNode.next?.`val`) {
                currentNode.next = currentNode.next?.next
            } else {
                currentNode = currentNode.next
            }
        }

        return head
    }
}