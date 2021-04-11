package easy

class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size) {
            result += Math.max(0, prices[i] - prices[i - 1])
        }
        return result
    }
}