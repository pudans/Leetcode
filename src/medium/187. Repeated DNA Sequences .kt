package medium

import HashTableTopic
import SlidingWindowTopic
import StringTopic

/**
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.
Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
You may return the answer in any order.
 */

class Medium187 : StringTopic, SlidingWindowTopic, HashTableTopic {

    fun findRepeatedDnaSequences(s: String): List<String> {
        val map = hashMapOf<String, Int>()
        val result = mutableListOf<String>()
        for (i in 0..s.length - 10) {
            val str = s.substring(i, i + 10)
            val count = map.getOrDefault(str, 0) + 1
            map[str] = count
            if (count == 2) result.add(str)
        }
        return result
    }
}

fun main() {
    println(Medium187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
    println(Medium187().findRepeatedDnaSequences("AAAAAAAAAAAAA"))
}