package easy

import LinkedListTopic
import TwoPointersTopic
import utils.ListNode
import utils.add

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */

class Easy876 : LinkedListTopic, TwoPointersTopic {

    fun middleNode(head: ListNode?): ListNode? {
        var temp = head
        var result = head
        var i = 0
        while (temp != null) {
            if (i % 2 == 1) {
                result = result?.next
            }
            temp = temp.next
            i++
        }
        return result
    }
}

fun main() {
    val head = ListNode(1)
    head.add(ListNode(2)).add(ListNode(3)).add(ListNode(4)).add(ListNode(5))
    println(Easy876().middleNode(head)?.`val`)
}