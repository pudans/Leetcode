package medium

import LinkedListTopic
import TwoPointersTopic
import utils.ListNode


/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/group-anagrams/
 *
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

 BULLSHIT
 */

class Medium82 : LinkedListTopic, TwoPointersTopic {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var newHead = head
        val sentinel = ListNode(0)
        sentinel.next = newHead

        var pred: ListNode? = sentinel
        while (newHead != null) {
            if (newHead.`val` == newHead.next?.`val`) {
                while (newHead?.`val` == newHead?.next?.`val`) {
                    newHead = newHead?.next
                }
                pred?.next = newHead?.next
            } else {
                pred = pred?.next
            }
            newHead = newHead?.next
        }
        return sentinel.next
    }
}