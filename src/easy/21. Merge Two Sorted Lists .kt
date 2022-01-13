package easy

import LinkedListTopic
import utils.ListNode
import utils.toStringList

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */

class Easy21 : LinkedListTopic {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        var l11 = l1
        var l22 = l2

        val head: ListNode = if (l1.`val` > l2.`val`) {
            l22 = l22.next
            l2
        } else {
            l11 = l11.next
            l1
        }
        var lastResult: ListNode? = head

        while (l11 != null || l22 != null) {
            val newRes: ListNode
            if (l11 != null && l22 != null) {
                if (l11.`val` > l22.`val`) {
                    newRes = l22
                    l22 = l22.next
                } else {
                    newRes = l11
                    l11 = l11.next
                }
            } else if (l11 != null) {
                newRes = l11
                l11 = l11.next
            } else {
                newRes = l22!!
                l22 = l22.next
            }
            lastResult?.next = newRes
            lastResult = lastResult?.next
        }
        return head
    }
}

fun main() {
    println(
        Easy21().mergeTwoLists(
            ListNode.create(ListNode(1), ListNode(2), ListNode(4)),
            ListNode.create(ListNode(1), ListNode(3), ListNode(4)),
        ).toStringList()
    )
}