package medium

import HashTableTopic
import StringTopic
import TrieTopic

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */

class Medium208 : HashTableTopic, StringTopic, TrieTopic {

    class Trie {

        val map = HashMap<Char, TrieNode>()

        fun insert(word: String) {
            if (word.isEmpty()) {
                return
            }
            var node: TrieNode? = map[word[0]]
            if (node == null) {
                node = TrieNode(word[0], word.length == 1, ArrayList())
                map.put(word[0], node)
            }
            for (i in 1 until word.length) {
                val newNodeIndex = node?.nodes?.indexOfFirst { it.value == word[i] } ?: -1
                var newNode = node?.nodes?.getOrNull(newNodeIndex)
                if (newNodeIndex >= 0 && newNode != null) {
                    if (i == word.length - 1) {
                        newNode.isEnd = i == word.length - 1
                        node?.nodes?.set(newNodeIndex, newNode)
                    }
                } else {
                    newNode = TrieNode(word[i], word.length - 1 == i, ArrayList())
                    node?.nodes?.add(newNode)

                }
                node = newNode
            }
        }

        fun search(word: String): Boolean {
            var node: TrieNode? = map[word[0]] ?: return false
            for (i in 1 until word.length) {
                val newNode = node!!.nodes.find { it.value == word[i] } ?: return false
                if (i == word.length - 1) {
                    return newNode.isEnd
                }
                node = newNode
            }
            return node?.isEnd == true
        }

        fun startsWith(word: String): Boolean {
            var node: TrieNode? = map[word[0]] ?: return false
            for (i in 1 until word.length) {
                val newNode = node!!.nodes.find { it.value == word[i] } ?: return false
                node = newNode
            }
            return true
        }
    }

    data class TrieNode(val value: Char, var isEnd: Boolean, val nodes: ArrayList<TrieNode>)
}


fun main() {
    val obj = Medium208.Trie()

    obj.insert("apple");
    println(obj.search("apple"))   // returns true
    println(obj.search("app"))     // returns false
    println(obj.startsWith("app")) // returns true
    obj.insert("app");
    println(obj.search("app"))     // returns true
}