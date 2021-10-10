package easy

/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class Solution70 {

    var map: IntArray? = null

    fun climbStairs(n: Int): Int {
        if (map == null) {
            map = IntArray(n + 1)
        }
        if (n <= 1) return 1
        if (n <= 4) return n
        var result = map?.getOrNull(n)
        if (result == null) {
            result = climbStairs(n - 1) + climbStairs(n - 2)
            map?.set(n, result)
        }
        return result
    }

    fun climbStairs2(n: Int): Int {
        if (n <= 1) return 1
        val array = IntArray(n + 1)
        array[0] = 0
        array[1] = 1
        array[2] = 2
        for (i in 3 until n + 1) {
            array[i] = array[i - 1] + array[i - 2]
        }
        return array[n]
    }
}

fun main() {
    println(Solution70().climbStairs2(2))
    println(Solution70().climbStairs2(3))
    println(Solution70().climbStairs2(14))
}