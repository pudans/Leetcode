package medium

import BacktrackingTopic
import StringTopic

/**
 * 1286. Iterator for Combination
 * https://leetcode.com/problems/iterator-for-combination/
 *
Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 */

class Medium1286: StringTopic, BacktrackingTopic {

    class CombinationIterator(private val characters: String, combinationLength: Int) {

        private val indexes = IntArray(combinationLength) { it }

        init {
            indexes[indexes.lastIndex]--
        }

        fun next(): String {
            updateIndexes(indexes.lastIndex)
            return indexes.joinToString("") { characters[it].toString() }
        }

        private fun updateIndexes(index: Int) {
            if (indexes[index] < characters.lastIndex - (indexes.lastIndex - index)) {
                indexes[index]++
            } else {
                updateIndexes(index - 1)
                indexes[index] = indexes[index - 1] + 1
            }
        }

        fun hasNext(): Boolean {
            for (i in indexes.indices) {
                if (indexes[i] < characters.lastIndex - (indexes.lastIndex - i)) {
                    return true
                }
            }
            return false
        }
    }
}

fun main() {
    var iterator = Medium1286.CombinationIterator("abc", 2)
    repeat(3) {
        println("ffff $it")
        println(iterator.next())
        println(iterator.hasNext())
    }

    println("-----------------")
    iterator = Medium1286.CombinationIterator("fiklnuy", 3)
    repeat(7 * (7 - 3 + 1)) {
        println("ffff $it")
        println(iterator.next())
        println(iterator.hasNext())
    }
}