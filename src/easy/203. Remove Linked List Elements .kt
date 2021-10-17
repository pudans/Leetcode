package easy

import utils.ListNode

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */

class Easy203 {

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