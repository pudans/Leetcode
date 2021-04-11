package medium

class Solution8 {

    fun myAtoi(str: String): Int {
        val newStr = str.trim()
        if (newStr.isEmpty()) {
            return 0
        }
        var isMinus = false
        var result = 0L
        when {
            newStr[0] == '-' -> isMinus = true
            newStr[0] == '+' -> isMinus = false
            newStr[0].isDigit() -> result = newStr[0].toString().toLong()
            else -> return 0
        }
        for (i in 1 until newStr.length) {
            if (newStr[i].isDigit()) {
                result = (result * 10) + newStr[i].toString().toInt()

                if (isMinus && -result < Int.MIN_VALUE ) {
                    return Int.MIN_VALUE
                } else if (result > Int.MAX_VALUE) {
                    return Int.MAX_VALUE
                }

            } else {
                if (isMinus) {
                    return -result.toInt()
                } else {
                    return result.toInt()
                }
            }
        }

        if (isMinus) {
            return -result.toInt()
        } else {
            return  result.toInt()
        }
    }
}