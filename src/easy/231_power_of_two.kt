package easy

class Solution231 {

    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 1) {
            return true
        }
        if (n == 2) {
            return true
        }
        if (n % 2 == 1) {
            return false
        }
        var temp = n
        while (n > 2) {
            temp /= 2
            if (temp == 2) {
                return true
            }
            if (temp % 2 == 1) {
                return false
            }
        }
        return false
    }
}