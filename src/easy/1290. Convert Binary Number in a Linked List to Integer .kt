package easy

import LinkedListTopic
import MathTopic
import StringTopic
import TwoPointersTopic
import utils.ListNode
import java.lang.StringBuilder

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 *
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
 */

class Easy1290: MathTopic, LinkedListTopic {

    fun getDecimalValue(head: ListNode?): Int {
        val builder = StringBuilder()
        var node = head
        while (node != null) {
            builder.append(node.`val`)
            node = node.next
        }
        return builder.toString().toInt(2)
    }
}