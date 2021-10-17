package easy

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

class Easy231 {

    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 1) return true
        if (n == 2) return true
        if (n % 2 == 1) return false
        var temp = n
        while (n > 2) {
            temp /= 2
            if (temp == 2) return true
            if (temp % 2 == 1) return false
        }
        return false
    }
}

fun main() {
    println(Easy231().isPowerOfTwo(1))
    println(Easy231().isPowerOfTwo(16))
    println(Easy231().isPowerOfTwo(3))
    println(Easy231().isPowerOfTwo(4))
    println(Easy231().isPowerOfTwo(5))
}