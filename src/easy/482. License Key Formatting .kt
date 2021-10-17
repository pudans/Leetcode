package easy

import java.lang.StringBuilder

/**
 * 482. License Key Formatting
 * https://leetcode.com/problems/license-key-formatting/
 *
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
 * The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group,
 * which could be shorter than k but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 * Return the reformatted license key.
 */

class Easy482 {

    fun licenseKeyFormatting(S: String, K: Int): String {
        val result = StringBuilder(S.filter { it != '-' }.uppercase())
        if (result.length <= K) return result.toString()
        val firstDash = result.length % K
        var i = firstDash + K
        if (firstDash != 0) {
            result.insert(firstDash, '-')
            i++
        }
        while (i < result.length) {
            result.insert(i, '-')
            i += K + 1
        }
        return result.toString()
    }
}

fun main() {
    println(Easy482().licenseKeyFormatting("5F3Z-2e-9-w", 4))
    println(Easy482().licenseKeyFormatting("2-5g-3-J", 2))
}