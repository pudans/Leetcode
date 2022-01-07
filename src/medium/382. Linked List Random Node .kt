package medium

import LinkedListTopic
import utils.ListNode
import kotlin.random.Random

/**
 * 382. Linked List Random Node
 * https://leetcode.com/problems/linked-list-random-node/
 *
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
Implement the Solution class:
Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.
 */

class Medium382 : LinkedListTopic {

    class Solution(private val head: ListNode) {

        fun getRandom(): Int {
            var chosen: ListNode = head
            var curr: ListNode? = head
            var scope = 1
            while (curr != null) {
                if (Random.nextFloat() < 1f / scope) chosen = curr
                scope++
                curr = curr.next
            }
            return chosen.`val`
        }
    }
}
