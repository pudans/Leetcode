package easy

import utils.ListNode

class Solution234 {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return true
        } else {
            val resultList = ArrayList<Int>()
            var currentNode = head
            while (currentNode != null) {
                resultList.add(currentNode.`val`)
                currentNode = currentNode.next
            }

            for (i in 0..resultList.size / 2) {
                if (resultList[i] != resultList[resultList.size - 1 - i]) {
                    return false
                }
            }
            return true
        }
    }
}