package hard

import HeapTopic
import LinkedListTopic
import utils.ListNode

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
 */

class Hard23 : LinkedListTopic, HeapTopic {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val head = getMin(lists)
        var node = head
        while (true) {
            val min = getMin(lists) ?: return head
            node?.next = min
            node = node?.next!!
            node.next = null
        }
    }

    private fun getMin(lists: Array<ListNode?>): ListNode? {
        var index = -1
        var result: ListNode? = null
        lists.forEachIndexed { i, node ->
            if (node != null && (result == null || result!!.`val` > node.`val`)) {
                result = node
                index = i
            }
        }
        if (index >= 0) lists[index] = lists[index]!!.next
        return result
    }
}