package easy

class Solution258 {

    fun addDigits(num: Int): Int {
        var sum = num
        while (sum > 9) {
            var newSum = 0
            sum.toString().forEach {
                newSum += it.toByte().toInt() - 48
            }
            sum = newSum
            println(newSum)
        }
        return sum
    }
}