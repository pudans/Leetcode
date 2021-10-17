package easy

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

class Easy242 {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        var sum1 = 0.0
        var sum2 = 0.0
        for (i in s.indices) {
            sum1 += Math.sin (s[i].code.toDouble())
            sum2 += Math.sin (t[i].code.toDouble())
        }
        return Math.abs(sum1 - sum2) < 0.0000000001
    }
}

fun main() {
    println(Easy242().isAnagram("anagram", "nagaram"))
    println(Easy242().isAnagram("rat", "car"))
}