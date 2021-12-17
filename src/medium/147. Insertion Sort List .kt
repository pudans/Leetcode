package medium

import LinkedListTopic
import SortingTopic
import TwoPointersTopic
import utils.ListNode
import utils.add
import utils.toStringList

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 *
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
The steps of the insertion sort algorithm:
Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm.
The partially sorted list (black) initially contains only the first element in the list.
One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 */

class Medium147: LinkedListTopic, SortingTopic {

    fun insertionSortList(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return head

        val list = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }
        list.sortBy { it.`val` }
        val newHead = list.first()
        var newNode = newHead
        for (i in 1 until list.size) {
            newNode.next = list[i]
            newNode = list[i]
        }
        list[list.lastIndex].next = null
        return newHead
    }

    // good but don't work
    fun insertionSortList1(head: ListNode?): ListNode? {
        head ?: return null
        var newHead = head
        var node = head

        while (node != null) {
//            println("----------")
//            println(node.`val`)
//            println(newHead.toStringList())
            if (node.next == null) break
            if (node.`val` < node.next!!.`val`) {
                node = node.next
                continue
            }
            val small = node.next!!
            node.next = node.next!!.next

            if (newHead!!.`val` > small.`val`) {
                small.next = newHead
                newHead = small
                continue
            }

            var smallNode = newHead
            while (smallNode != null) {
//                println("**********8")
//                println(small.`val`)
//                println(smallNode.toStringList())
                if (smallNode.next == null) {
                    small.next = null
                    smallNode.next = small
                    node = node!!.next
                    break
                }
                if (smallNode.`val` < small.`val` && smallNode.next!!.`val` > small.`val`) {
                    small.next = smallNode.next
                    smallNode.next = small
                    break
                }
                smallNode = smallNode.next
            }
        }
        return newHead
    }
}

fun main() {
    val head = ListNode(4)
    head.add(ListNode(2)).add(ListNode(1)).add(ListNode(3))
    println(Medium147().insertionSortList(head).toStringList())

    val head1 = ListNode(-1)
    head1.add(ListNode(5)).add(ListNode(3)).add(ListNode(4)).add(ListNode(0))
    println(Medium147().insertionSortList(head1).toStringList())

    val head2 = ListNode(1)
    head2.add(ListNode(1))
    println(Medium147().insertionSortList(head2).toStringList())
}