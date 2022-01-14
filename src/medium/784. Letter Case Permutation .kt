package medium

import BacktrackingTopic
import StringTopic

/**
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
 *
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.
 */

class Medium784 : StringTopic, BacktrackingTopic {

    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()
        val positions = mutableListOf<Int>()
        s.forEachIndexed { index, c -> if (!c.isDigit()) positions.add(index) }
        val variants = Math.pow(2.0, positions.size.toDouble()).toInt()
        repeat(variants) { variant ->
            val copy = s.toCharArray()
            var z = 2
            positions.forEach { pos ->
                val dd = variants / z
                val gg = (variant / dd) % 2 == 0
                copy[pos] = if (gg) copy[pos].toLowerCase() else copy[pos].toUpperCase()
                z *= 2
            }
            result.add(String(copy))
        }
        return result
    }
}

fun main() {
    println(Medium784().letterCasePermutation("a1b2"))
    println(Medium784().letterCasePermutation("3z4"))
}