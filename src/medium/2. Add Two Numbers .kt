package medium

import LinkedListTopic
import MathTopic
import RecursionTopic
import utils.ListNode

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

class Medium2 : LinkedListTopic, MathTopic, RecursionTopic {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var stepRes: ListNode? = null
        var first = l1
        var second = l2
        var isAddOne = false

        while (first != null || second != null) {
            var newValue = (first?.`val` ?: 0) + (second?.`val` ?: 0)
            if (isAddOne) newValue++
            isAddOne = newValue >= 10
            newValue %= 10
            val newNode = ListNode(newValue)
            if (stepRes != null) {
                stepRes.next = newNode
                stepRes = stepRes.next
            } else {
                result = newNode
                stepRes = newNode
            }
            first = first?.next
            second = second?.next
        }
        if (isAddOne) {
            stepRes?.next = ListNode(1)
        }
        return result
    }
}