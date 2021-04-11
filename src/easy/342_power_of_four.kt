package easy

class Solution342 {
    fun isPowerOfFour(num: Int): Boolean {
        if (num > 4) {
            if (num % 4 == 0) {
                return isPowerOfFour(num / 4)
            } else {
                return false
            }
        } else return num == 4|| num == 1
    }
}