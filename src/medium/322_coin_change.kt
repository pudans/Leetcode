package medium

class Solution322 {

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dd = IntArray(amount + 1) { Int.MAX_VALUE }
        dd[0] = 0
        for (i in 1 until dd.size) {
            for (coin in coins) {
                if (coin <= i && dd[i - coin] != Int.MAX_VALUE) {
                    dd[i] = Math.min(dd[i - coin] + 1, dd[i])
                }
            }
        }
        return if (dd[amount] == Int.MAX_VALUE) -1 else dd[amount]

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            val d = Solution322().coinChange(intArrayOf(186,419,83,408), 6249)
            val d = Solution322().coinChange(intArrayOf(1,2,5), 11)

            println(d)
        }
    }
}