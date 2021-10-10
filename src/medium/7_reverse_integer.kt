package medium

class Solution7 {

    fun reverse(x: Int): Int {
        try {
            val number = (Math.abs(x)).toString().reversed().toLong()
            if (number > Int.MAX_VALUE) {
                return 0
            } else {
                return if (x < 0) - number.toInt() else number.toInt()
            }
        } catch (e: Exception) {
            return 0
        }
    }
}