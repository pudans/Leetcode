package easy

class Solution66 {

    fun plusOne(digits: IntArray): IntArray {
        var index = digits.size - 1
        while (true) {
            if (digits[index] == 9) {
                digits[index] = 0
                if (index == 0) {
                    return IntArray(digits.size + 1) { ii ->
                        if (ii == 0) 1 else 0
                    }
                } else {
                    index--
                }
            } else if (digits[index] <= 9) {
                digits[index]++
                return digits
            } else {
                digits[index] = 0
                return digits
            }
        }
    }
}