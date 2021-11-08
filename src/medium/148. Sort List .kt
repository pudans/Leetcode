package medium

import LinkedListTopic
import SortingTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */

class Medium148: LinkedListTopic, TwoPointersTopic, SortingTopic {

    fun merge(lst1: ListNode?, lst2: ListNode?): ListNode? {
        if (lst1 == null) return lst2
        if (lst2 == null) return lst1

        val result: ListNode
        if (lst1.`val` <= lst2.`val`) {
            result = lst1
            result.next = merge(lst1.next, lst2)
        } else {
            result = lst2
            result.next = merge(lst1, lst2.next)
        }
        return result
    }

    //splitting list into two halves
    fun FrontBackSplit(ptr: ListNode?): Array<ListNode?> {
        // base case
        if (ptr?.next == null) {
            return arrayOf(ptr, null)
        }
        var backward = ptr
        var forward = ptr.next

        // Forward moves twice and backward moves once
        while (forward != null) {
            forward = forward.next
            if (forward != null) {
                backward = backward!!.next
                forward = backward!!.next
            }
        }

        // splitting the linked list
        val arr = arrayOf(ptr, backward!!.next)
        backward.next = null
        return arr
    }

    // Sorting linked list using merge sort.
    fun sortList(head: ListNode?): ListNode? {
        // Base case
        if (head?.next == null) {
            return head
        }
        val arr = FrontBackSplit(head)
        var first_half = arr[0]
        var second_half = arr[1]
        first_half = sortList(first_half)
        second_half = sortList(second_half)

        // merge the two sorted list into single list.
        return merge(first_half, second_half)
    }
}