package medium

import HashTableTopic
import LinkedListTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 */

class Medium142 : HashTableTopic, LinkedListTopic, TwoPointersTopic {

    fun detectCycle(head: ListNode?): ListNode? {
        head ?: return null
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