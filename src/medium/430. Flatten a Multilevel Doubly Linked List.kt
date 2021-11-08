package medium

import DFSTopic
import DoubleLinkedListTopic
import LinkedListTopic
import java.util.*

/**
 * 430. Flatten a Multilevel Doubly Linked List
 * https://leetcode.com/problems/merge-intervals/
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 */

class Medium430: LinkedListTopic, DFSTopic, DoubleLinkedListTopic {

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }

    fun flatten(root: Node?): Node? {
        root ?: return null
        val head: Node? = root
        var result: Node? = null
        var node = root
        val stack = Stack<Node>()

        while (node != null) {
            if (result == null) {
                result = node
            } else {
                node.prev = result
                result.next = node
                result = result.next
            }

            node = when {
                node.child != null -> {
                    if (node.next != null) {
                        stack.add(node.next)
                    }
                    node.child
                }
                node.next != null -> node.next
                stack.isNotEmpty() -> stack.pop()
                else -> null
            }
            result?.next = null
            result?.child = null
        }
        return head
    }
}