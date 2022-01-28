package easy

import ArraysTopic
import StringTopic

/**
 * 2114. Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 *
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
You are given an array of strings sentences, where each sentences[i] represents a single sentence.
Return the maximum number of words that appear in a single sentence.
 */

class Easy2114 : ArraysTopic, StringTopic {

    fun mostWordsFound(sentences: Array<String>): Int =
        sentences.map { it.count { it == ' ' } + 1}.maxOf { it }
}

fun main() {
    println(Easy2114().mostWordsFound(arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much")))
    println(Easy2114().mostWordsFound(arrayOf("please wait", "continue to fight", "continue to win")))

}