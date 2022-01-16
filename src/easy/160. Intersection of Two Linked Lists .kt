package easy

import HashTableTopic
import LinkedListTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 */

class Easy160 : HashTableTopic, LinkedListTopic, TwoPointersTopic {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var tempA = headA
        while (tempA != null) {
            var tempB = headB
            while (tempB != null) {
                if (tempA === tempB && checkEqual(tempA, tempB)) return tempA
                tempB = tempB.next
            }
            tempA = tempA.next
        }
        return null
    }

    private fun checkEqual(headA: ListNode, headB: ListNode): Boolean {
        var tempA: ListNode? = headA
        var tempB: ListNode? = headB
        while (tempA != null && tempB != null) {
            if (tempA.`val` != tempB.`val`) return false
            tempA = tempA.next
            tempB = tempB.next
            if (tempA == null && tempB != null) return false
            if (tempB == null && tempA != null) return false
        }
        return true
    }
}