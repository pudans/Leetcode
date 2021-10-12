package easy

import utils.ListNode
import utils.toStringList

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */

class Easy21 {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 != null && l2 != null) {

            var l11 = l1
            var l22 = l2

            val result: ListNode = if (l1.`val` > l2.`val`) {
                l22 = l2.next
                ListNode(l2.`val`)
            } else {
                l11 = l1.next
                ListNode(l1.`val`)
            }
            var lastResult: ListNode? = null
            lastResult = result

            while (l11 != null || l22 != null) {
                val newRes: ListNode
                if (l11 != null && l22 != null) {
                    if (l11.`val` > l22.`val`) {
                        newRes = ListNode(l22.`val`)
                        l22 = l22.next
                    } else {
                        newRes = ListNode(l11.`val`)
                        l11 = l11.next
                    }
                } else if (l11 != null) {
                    newRes = ListNode(l11.`val`)
                    l11 = l11.next
                } else {
                    newRes = ListNode(l22?.`val` ?: -1)
                    l22 = l22?.next
                }
                lastResult?.next = newRes
                lastResult = newRes
            }
            return result

        } else if (l1 != null) {
            return l1
        } else {
            return l2
        }
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