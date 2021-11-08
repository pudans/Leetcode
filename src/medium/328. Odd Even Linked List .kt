package medium

import LinkedListTopic
import utils.ListNode

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

class Medium328 : LinkedListTopic {

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null || head.next?.next == null) {
            return head
        }

        var temp: ListNode? = head!!.next!!.next

        val result: ListNode? = ListNode(head.`val`)
        var tempResult = result

        var oddResult: ListNode? = ListNode(head.next!!.`val`)
        var tempOddResult = oddResult

        var i = 2

        while (temp != null) {
            if (i % 2 == 0) {
                tempResult?.next = ListNode(temp.`val`)
                tempResult = tempResult?.next
            } else {
                tempOddResult?.next = ListNode(temp.`val`)
                tempOddResult = tempOddResult?.next
            }
            temp = temp.next
            i++
        }
        log(result)
        log(oddResult)

        tempResult?.next = oddResult

        return result
    }


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val s1 = ListNode(1)
            val s2 = ListNode(2)
            val s3 = ListNode(3)
            val s4 = ListNode(4)
            val s5 = ListNode(5)
            s1.next = s2
            s2.next = s3
            s3.next = s4
            s4.next = s5

            val ss = Medium328().oddEvenList(s1)
            println()
            print("result")
            log(ss)
        }

        private fun log(head: ListNode?) {
            println()
            var temp = head
            while (temp != null) {
                print(", ${temp.`val`}")
                temp = temp.next
            }
        }
    }
}