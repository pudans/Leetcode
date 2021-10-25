package medium

import LinkedListTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

class Medium19: LinkedListTopic, TwoPointersTopic {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = ArrayList<ListNode>()
        var temp = head
        while (temp != null) {
            list.add(temp)
            temp = temp.next
        }
        return if (n == list.size) {
            head?.next
        } else {
            val dd = list[list.size - (n + 1)]
            dd.next = dd.next?.next
            head
        }
    }
}