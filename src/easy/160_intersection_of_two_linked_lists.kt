package easy

import utils.ListNode

class Solution160 {

    fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {

        var result: ListNode? = null
        var tempA = headA
        while (tempA != null) {

            var tempB = headB
            while (tempB != null) {

                if (tempA === tempB && checkEqual(tempA, tempB)) {
                    result = tempA
                    return result
                }
                tempB = tempB.next
            }
            tempA = tempA.next
        }
        return result
    }

    fun checkEqual(headA: ListNode, headB:ListNode): Boolean {
        var tempA: ListNode? = headA
        var tempB: ListNode? = headB
        while (tempA != null && tempB != null) {
            if (tempA.`val` != tempB.`val`) {
                return false
            }
            tempA = tempA.next
            tempB = tempB.next

            if (tempA == null && tempB != null) {
                return false
            }
            if (tempB == null && tempA != null) {
                return false
            }
        }
        return true
    }
}