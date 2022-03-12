package easy

import LinkedListTopic
import StackTopic
import TwoPointersTopic
import utils.ListNode

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 */

class Easy234 : LinkedListTopic, TwoPointersTopic, StackTopic {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        val list = ArrayList<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        for (i in 0..list.size / 2) {
            if (list[i] != list[list.size - 1 - i]) {
                return false
            }
        }
        return true
    }
}