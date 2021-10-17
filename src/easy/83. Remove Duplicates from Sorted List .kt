package easy

import LinkedListTopic
import utils.ListNode

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */

class Easy83: LinkedListTopic {

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

fun main() {
    // TODO
}