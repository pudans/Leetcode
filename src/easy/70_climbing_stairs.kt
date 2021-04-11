package easy

class Solution70 {

    var map: IntArray? = null
    fun climbStairs(n: Int): Int {
        if (map == null) {
            map = IntArray(n + 1)
        }
        if (n <= 1) {
            return 1;
        }
        val mem = map?.getOrNull(n)
        if (mem != null && mem != 0) {
            return mem;
        } else {
            val result = climbStairs(n - 1) + climbStairs(n - 2)
            map?.set(n, result)
            return result
        }
    }
}