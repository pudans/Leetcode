package medium

import StringTopic
import TwoPointersTopic

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 *
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'.
Each revision consists of digits and may contain leading zeros. Every revision contains at least one character.
Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on.
For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order.
Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal.
If a version number does not specify a revision at an index, then treat the revision as 0.
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 */

class Medium165 : TwoPointersTopic, StringTopic {

    fun compareVersion(version1: String, version2: String): Int {
        val split1 = version1.split(".")
        val split2 = version2.split(".")
        for (i in 0 until maxOf(split1.size, split2.size)) {
            val s1 = split1.getOrNull(i)?.let { Integer.parseInt(it) } ?: 0
            val s2 = split2.getOrNull(i)?.let { Integer.parseInt(it) } ?: 0
            if (s1 > s2) return 1
            if (s1 < s2) return -1
        }
        return 0
    }
}

fun main() {
    println(Medium165().compareVersion("1.01", "1.001"))
    println(Medium165().compareVersion("1.0", "1.0.0"))
    println(Medium165().compareVersion("0.1", "1.1"))
    println(Medium165().compareVersion("4.08", "4.08.01"))
}