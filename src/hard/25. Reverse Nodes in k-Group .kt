package hard

import LinkedListTopic
import utils.ListNode

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */

class Hard25 : LinkedListTopic {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val list = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }
        val chunked = list.chunked(k) { if (it.size == k) it.reversed() else it }
        var newHead: ListNode? = null
        var step: ListNode? = null
        chunked.forEach { subList ->
            subList.forEach {
                if (newHead == null) {
                    newHead = it
                    step = it
                } else {
                    step?.next = it
                    step = step?.next
                }
            }
        }
        step?.next = null
        return newHead
    }
}