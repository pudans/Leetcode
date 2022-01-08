package medium

import LinkedListTopic
import TwoPointersTopic
import utils.ListNode
import utils.add
import utils.toStringList

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

class Medium19 : LinkedListTopic, TwoPointersTopic {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        var dd = head
        var temp = head
        var i = 0
        while (temp != null) {
            if (i > n) {
                dd = dd?.next
            }
            temp = temp.next
            i++
        }
        if (i < n) return null
        if (i == n) return head.next
        dd?.next = dd?.next?.next
        return head
    }
}

fun main() {
    val head = ListNode(1)
    head.add(ListNode(2)).add(ListNode(3)).add(ListNode(4)).add(ListNode(5))
    println(Medium19().removeNthFromEnd(head, 2)?.toStringList())
}