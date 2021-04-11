package medium

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.arrayListOf
import kotlin.collections.forEachIndexed
import kotlin.collections.toList


class Solution127 {

    /**
     * Bullshit
     */

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = HashSet(wordList) // for quick lookup convert list to set
        val queue = LinkedList<String>()
        val visited = HashSet<String>()
        queue.add(beginWord) // add beginWord in queue
        visited.add(beginWord) // mark visited beginWord
        var level = 0 // initialize level
        while (!queue.isEmpty()) {
            var size = queue.size // for level by level
            level++
            while (size-- > 0) {
                val word = queue.poll()
                if (endWord == word) // if current word is endWord return level
                    return level
                for (i in word!!.indices) { // for each characters of word
                    for (j in 0..25) { // replace with a-z
                        val newWord = word.substring(0, i) + ('a'.toInt() + j).toChar() + word.substring(i + 1)
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) { // check if newWrod is in wordSet and not visited
                            queue.add(newWord) // add in queue
                            visited.add(newWord) // mark visited
                        }
                    }
                }
            }
        }
        return if (visited.contains(endWord)) level else 0 // check if we are able to reach endWord
    }

    lateinit var wordList: List<String>

    fun ladderLength1(beginWord: String, endWord: String, wordList: List<String>): Int {
        this.wordList = wordList
        val len = beginWord.length

        val result = ArrayList<String>()
        var temp = beginWord
        val checked = BooleanArray(wordList.size)

        var findResult = true
        while (temp != endWord && findResult) {
            findResult = false
            wordList.forEachIndexed { index, str ->

                println(str)
                println(temp)
                println(checked.toList())
                println(canReplace(str, temp))

                if (str == beginWord) {
                    checked[index] = true
                } else if (!checked[index] && canReplace(str, temp)) {
                    findResult = true
                    checked[index] = true
                    temp = str
                    result.add(str)
                }
            }
        }

        println(result)

        return if (temp == endWord) result.size else 0
    }

    fun canReplace(str1: String, str2: String): Boolean {
        var hasOneChange = false

        str1.forEachIndexed { index, c ->
            if (c != str2[index]) {
                if (hasOneChange) {
                    return false
                }
                hasOneChange = true
            }
        }
        return hasOneChange
    }
}

fun main(args: Array<String>) {
    val result = Solution127().ladderLength(
            "hot",
            "dog",
            arrayListOf("hot", "dog", "dot")
    )
    println(result)
}