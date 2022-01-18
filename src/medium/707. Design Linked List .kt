package medium

import LinkedListTopic

/**
 * 707. Design Linked List
 * https://leetcode.com/problems/design-linked-list/
 *
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list.
After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
If index equals the length of the linked list, the node will be appended to the end of the linked list.
If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */

class Medium707 : LinkedListTopic {

    class MyLinkedList {

        class ListNode(var `val`: Int) {
            var next: ListNode? = null
            var prev: ListNode? = null
        }

        fun ListNode?.toStringList(): String? {
            if (this == null) return null
            var str = ""
            var node: ListNode? = this
            while (node != null) {
                str = str.plus(if (str.isNotEmpty()) " -> " else "")
                str = str.plus("(${node.prev?.`val`} - ${node.`val`} - ${node.next?.`val`})")
                node = node.next
            }
            return str
        }

        var size = 0
        var head: ListNode? = null
        var tail: ListNode? = null

        fun get(index: Int): Int {
            println("get $index ${toString()}")

            var node = head
            var i = 0
            while (node != null && i < index) {
                i++
                node = node.next
            }
            if (node != null) return node.`val`
            return -1
        }

        fun addAtHead(`val`: Int) {
            println("addAtHead $`val` ${toString()}")

            if (head == null) {
                head = ListNode(`val`)
                tail = head
            } else {
                val temp = ListNode(`val`)
                temp.next = head
                head?.prev = temp
                head = temp
            }
            size++
        }

        fun addAtTail(`val`: Int) {
            println("addAtTail $`val` ${toString()}")

            if (tail == null) {
                addAtHead(`val`)
                return
            }
            val temp = ListNode(`val`)
            temp.prev = tail
            tail?.next = temp
            tail = temp
            size++
        }

        fun addAtIndex(index: Int, `val`: Int) {
            println("addAtIndex $index $`val` ${toString()}")

            if (size == index) {
                addAtTail(`val`)
                return
            }
            if (index == 0) {
                addAtHead(`val`)
                return
            }
            var node = head
            var i = 1
            while (node != null && i < index) {
                i++
                node = node.next
            }
            if (node != null) {
                val temp = ListNode(`val`)
                temp.prev = node
                temp.next = node.next
                temp.next?.prev = temp
                node.next = temp
                size++
            }
        }

        fun deleteAtIndex(index: Int) {
            println("deleteAtIndex $index ${toString()}")
            if (index >= size) return
            if (index == 0) {
                head = head?.next
                head?.prev = null
                size--
                return
            }
            if (index == size - 1) {
                tail = tail?.prev
                tail?.next = null
                size--
                return
            }
            var node = head
            var i = 1
            while (node != null && i < index) {
                i++
                node = node.next
            }
            if (node != null) {
                node.next = node.next?.next
                node.next?.prev = node
                size--
            }
        }

        override fun toString(): String = ("size $size " + head.toStringList() + " | " + tail.toStringList())

    }
}

fun main() {
    var list = Medium707.MyLinkedList()
//    list.addAtHead(1)
//    println(list.toString())
//    list.addAtTail(3)
//    println(list.toString())
//    list.addAtIndex(1, 2)
//    println(list.toString())
//    println(list.get(1))
//    list.deleteAtIndex(1)
//    println(list.toString())
//    println(list.get(1))

//    list = Medium707.MyLinkedList()
//    list.addAtHead(7)
//    println(list.toString())
//    list.addAtHead(2)
//    println(list.toString())
//    list.addAtHead(1)
//    println(list.toString())
//    list.addAtIndex(3, 0)
//    println(list.toString())
//    list.deleteAtIndex(2)
//    println(list.toString())
//    list.addAtHead(6)
//    println(list.toString())
//    list.addAtTail(4)
//    println(list.toString())
//    println(list.get(4))

//    list = Medium707.MyLinkedList()
//    list.addAtHead(1)
//    println(list.toString())
//    list.addAtTail(3)
//    println(list.toString())
//    list.addAtIndex(1,2)
//    println(list.toString())
//    println(list.get(1))
//    list.deleteAtIndex(0)
//    println(list.toString())
//    println(list.get(0))

    list = Medium707.MyLinkedList()
    list.addAtHead(4)
    println(list.toString())
    list.addAtHead(1)
    println(list.toString())
    list.addAtHead(5)
    println(list.toString())
    list.deleteAtIndex(3)
    println(list.toString())
    list.addAtHead(7)
    println(list.toString())
    println(list.get(3))
}