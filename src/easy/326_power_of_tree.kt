package easy

class Solution326 {
    fun isPowerOfThree(n: Int): Boolean {
        if (n > 3) {
            if (n % 3 == 0) {
                return isPowerOfThree(n / 3)
            } else {
                return false
            }
        } else return n == 3|| n == 1
    }
}