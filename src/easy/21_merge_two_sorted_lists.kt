package easy

import utils.ListNode

class Solution21 {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 != null && l2 != null) {

            var l11 = l1
            var l22 = l2

            var result: ListNode = if (l1.`val` > l2.`val`) {
                l22 = l2.next
                ListNode(l2.`val`)
            } else {
                l11 = l1.next
                ListNode(l1.`val`)
            }
            var lastResult: ListNode? = null
            lastResult = result

            while (l11 != null || l22 != null) {
                val newRes: ListNode
                if (l11 != null && l22 != null) {
                    if (l11.`val` > l22.`val`) {
                        newRes = ListNode(l22.`val`)
                        l22 = l22.next
                    } else {
                        newRes = ListNode(l11.`val`)
                        l11 = l11.next
                    }
                } else if (l11 != null) {
                    newRes = ListNode(l11.`val`)
                    l11 = l11.next
                } else {
                    newRes = ListNode(l22?.`val` ?: -1)
                    l22 = l22?.next
                }
                lastResult?.next = newRes
                lastResult = newRes
            }
            return result
        }
        else if (l1 != null) {
            return l1
        } else {
            return l2
        }
    }
}