package easy

import utils.ListNode

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 */

class Easy234 {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
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