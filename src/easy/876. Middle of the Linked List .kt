package easy

import utils.ListNode

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */

class Easy876 {

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