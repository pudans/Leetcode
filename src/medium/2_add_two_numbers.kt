package medium

import utils.ListNode

class Solution2 {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var stepRes: ListNode? = null
        var first = l1
        var second = l2
        var isAddOne = false

        while (first != null || second != null) {
            var newValue = when {
                first != null && second != null -> {
                    first.`val` + second.`val`
                }
                first != null -> first.`val`
                else -> second?.`val` ?: 0
            }

            if (isAddOne) {
                newValue++
                isAddOne = false
            }
            if (newValue >= 10) {
                isAddOne = true
                newValue -= 10
            }

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