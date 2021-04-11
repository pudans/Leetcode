package easy

class Solution202 {
    fun isHappy(n: Int): Boolean {
        var param = n
        var loopCount = 0

        if (n == 1) {
            return true
        }

        while (loopCount < 10) {
            var value = 0
            param.toString().forEach { char ->
                val d = Character.getNumericValue(char)
                value += d * d
            }

            if (value == 1) {
                return true
            } else {
                param = value
            }
            loopCount++
        }
        return false
    }
}