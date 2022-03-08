package easy

import HashTableTopic
import LinkedListTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */

class Easy141 : HashTableTopic, LinkedListTopic, TwoPointersTopic {

    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false
        head.next ?: return false
        head.next?.next ?: return false
        if (head === head.next) return true
        var t1 = head
        var t2 = head.next?.next
        while (true) {
            when {
                t1 === t2 -> return true
                t2?.next != null && t2.next!!.next != null -> {
                    t1 = t1?.next
                    t2 = t2.next?.next
                }
                else -> return false
            }
        }
    }
}