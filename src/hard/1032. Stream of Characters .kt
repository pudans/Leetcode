package hard

import ArraysTopic
import TrieTopic


/**
 * 1032. Stream of Characters
 * https://leetcode.com/problems/stream-of-characters/
 *
Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.
For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z',
your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.
Implement the StreamChecker class:
StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 */

class Hard1032 : ArraysTopic, TrieTopic {

    class StreamChecker(private val words: Array<String>) {
        var input = ""
        fun query(letter: Char): Boolean {
            input += letter

            words.forEach { word ->
                val result = check(word)
                if (result) {
                    return true
                }
            }
            return false
        }

        private fun check(word: String): Boolean {
            if (word.length > input.length) return false
            var result = true
            for (i in word.lastIndex downTo 0) {
                result = result && word[i] == input[i + (input.length - word.length)]
                if (!result) return false
            }
            return true
        }
    }
}

fun main() {
    val checker1 = Hard1032.StreamChecker(arrayOf("abc", "xyz"))
    println(checker1.query('a'))
    println(checker1.query('x'))
    println(checker1.query('y'))
    println(checker1.query('z'))
    println("-----------------------")
    val checker2 = Hard1032.StreamChecker(arrayOf("cd", "f", "kl"))
    println(checker2.query('a'))
    println(checker2.query('b'))
    println(checker2.query('c'))
    println(checker2.query('d'))
    println(checker2.query('e'))
    println(checker2.query('f'))
    println(checker2.query('g'))
    println(checker2.query('h'))
    println(checker2.query('i'))
    println(checker2.query('j'))
    println(checker2.query('k'))
    println(checker2.query('l'))
}