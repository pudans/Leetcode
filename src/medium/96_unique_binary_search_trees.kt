package medium

class Solution96 {

    fun numTrees(n: Int): Int {
        val arr = IntArray(n + 1)
        arr[0] = 1
        arr[1] = 1
        for (i in 2..n) {
            for (j in 0 until i) {
                arr[i] += arr[j] * arr[i - j - 1]
            }
        }
        return arr[n]
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution96().numTrees(3)
            println(dd)
        }
    }
}