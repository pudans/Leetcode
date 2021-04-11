package easy

class Solution121 {

    fun maxProfit(prices: IntArray): Int {
        var result = 0

        var min = Int.MAX_VALUE
        var profit = 0
        prices.forEach {
            if (it < min) {
                if (result < profit) {
                    result = profit
                }
                profit = 0
                min = it
            } else {
                if (it - min > profit) {
                    profit = it - min
                }
            }
        }
        if (profit > result) {
            result = profit
        }
        return result
    }
}