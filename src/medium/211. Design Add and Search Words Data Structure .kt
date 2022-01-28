package medium

import DFSTopic
import StringTopic
import TrieTopic

/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
Design a data structure that supports adding new words and finding if a string matches any previously added string.
Implement the WordDictionary class:
WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
word may contain dots '.' where dots can be matched with any letter.
 */

class Medium211 : StringTopic, DFSTopic, TrieTopic {

    class WordDictionary {

        class Node(val value: Char, var isEnd: Boolean = false) {
            val nodes = mutableListOf<Node>()
            override fun toString(): String = "$value - $isEnd"
        }

        private val head = Node(' ')

        fun addWord(word: String) {
            if (word.isEmpty()) return
            var node: Node = head
            for (i in word.indices) {
                val newNodeIndex = node.nodes.indexOfFirst { it.value == word[i] }
                var newNode = node.nodes.getOrNull(newNodeIndex)
                if (newNodeIndex >= 0 && newNode != null) {
                    if (i == word.lastIndex) {
                        newNode.isEnd = true
                        node.nodes[newNodeIndex] = newNode
                    }
                } else {
                    newNode = Node(word[i], word.lastIndex == i)
                    node.nodes.add(newNode)

                }
                node = newNode
            }
        }

        fun search(word: String, pos: Int = 0, prevNode: Node = head): Boolean {
            if (pos == word.length) return prevNode.isEnd
            val ch = word[pos]
            if (ch == '.') {
                return prevNode.nodes.any { search(word, pos + 1, it) }
            } else {
                val node = prevNode.nodes.find { it.value == ch } ?: return false
                return search(word, pos + 1, node)
            }
        }

        override fun toString(): String {
            val result = ArrayList<ArrayList<Node>>()
            fun traverse(root: Node, level: Int = 0) {
                val dd = result.getOrElse(level) { ArrayList(level * 2) }
                dd.add(root)
                if (result.size <= level) result.add(dd) else result[level] = dd
                root.nodes.forEach { traverse(it, level + 1) }
            }
            traverse(head)
            val builder = StringBuilder()
            result.forEachIndexed { index, arrayList ->
                builder.append(index).append(": ")
                builder.append(arrayList.joinToString { it.toString() })
                builder.append("\n")
            }
            return builder.toString()
        }
    }
}

fun main() {
    val dict = Medium211.WordDictionary()
    dict.addWord("bad")
    dict.addWord("dad")
    dict.addWord("mad")
    println(dict)
    println(dict.search("pad"))
    println(dict.search("bad"))
    println(dict.search(".ad"))
    println(dict.search("b.."))
}