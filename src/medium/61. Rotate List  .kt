package medium

import LinkedListTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 *
Given the head of a linked list, rotate the list to the right by k places.
 */

class Medium61 : LinkedListTopic, TwoPointersTopic {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        val list = ArrayList<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }
        val sentinel = ListNode(0)
        node = sentinel
        for (i in list.indices) {
            node?.next = list[(i - (k % list.size) + list.size) % list.size]
            node = node?.next
        }
        node?.next = null
        return sentinel.next
    }
}