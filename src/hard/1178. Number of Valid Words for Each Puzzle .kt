package hard

import ArraysTopic
import BitManipulationTopic
import HashTableTopic
import TrieTopic


/**
 * 1178. Number of Valid Words for Each Puzzle
 * https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 *
With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
word contains the first letter of puzzle.
For each letter in word, that letter is in puzzle.
For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage", while
invalid words are "beefed" (does not include 'a') and "based" (includes 's' which is not in the puzzle).
Return an array answer, where answer[i] is the number of words in the given word list words that is valid with respect to the puzzle puzzles[i].
 */

class Hard1178 : ArraysTopic, HashTableTopic, BitManipulationTopic, TrieTopic {

    fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
        val puzzleMasks = IntArray(puzzles.size) { calculateMask(puzzles[it]) }
        val firstWordMasks = IntArray(puzzles.size) { 1 shl puzzles[it].first() - 'a' }
        val wordMasks = IntArray(words.size) { calculateMask(words[it]) }
        val result = ArrayList<Int>(puzzles.size)
        puzzleMasks.forEachIndexed { i, puzzleMask ->
            val countMatch = wordMasks.count { wordMask ->
                firstWordMasks[i] and wordMask > 0 && puzzleMask or wordMask == puzzleMask
            }
            result.add(countMatch)
        }
        return result
    }

    private fun calculateMask(word: String): Int {
        var mask = 0
        for (c in word.toCharArray()) {
            mask = mask or (1 shl c - 'a')
        }
        return mask
    }

    fun findNumOfValidWords2(words: Array<String>, puzzles: Array<String>): List<Int> {
        val result = ArrayList<Int>(words.size)
        val set = HashSet<Char>(7)
        puzzles.forEach { puzzle ->
            puzzle.forEach { set.add(it) }
            val res = words.count { word -> word.contains(puzzle.first()) && word.all { char -> set.contains(char) } }
            set.clear()
            result.add(res)
        }
        return result
    }
}

fun main() {
    println(Hard1178().findNumOfValidWords(
        arrayOf("aaaa","asas","able","ability","actt","actor","access"),
        arrayOf("aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz")
    ))
    println(Hard1178().findNumOfValidWords(
        arrayOf("apple","pleas","please"),
        arrayOf("aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy")
    ))
}