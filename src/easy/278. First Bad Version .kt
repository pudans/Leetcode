package easy

import BinarySearchTopic

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

abstract class VersionControl {
    var badVersion = 0
    open fun isBadVersion(version: Int): Boolean = version >= badVersion
    abstract fun firstBadVersion(n: Int): Int
}

class Easy278 : VersionControl(), BinarySearchTopic {

    private var minBadVersion = Int.MAX_VALUE

    override fun firstBadVersion(n: Int): Int = findInRange(IntRange(1, n))

    private fun findInRange(range: IntRange): Int =
        if (range.first == range.last) {
            if (isBadVersion(range.first)) range.first else minBadVersion
        } else {
            val mid = ((range.first.toLong() + range.last.toLong()) / 2L).toInt()
            if (isBadVersion(mid)) {
                minBadVersion = minOf(minBadVersion, mid)
                findInRange(IntRange(range.first, maxOf(range.first, mid - 1)))
            } else {
                findInRange(IntRange(minOf(mid + 1, range.last), range.last))
            }
        }
}

fun main() {
    val dd = Easy278()
    dd.badVersion = 1702766719
    println(dd.firstBadVersion(2126753390))

    dd.badVersion = 4
    println(dd.firstBadVersion(5))

    dd.badVersion = 1
    println(dd.firstBadVersion(1))
}