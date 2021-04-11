package easy

class Solution13 {

    fun romanToInt(s: String): Int {
        var result = 0
        s.forEachIndexed { index, char ->
            when (char) {
                'I' -> result += 1
                'V' -> result += 5
                'X' -> result += 10
                'L' -> result += 50
                'C' -> result += 100
                'D' -> result += 500
                'M' -> result += 1000
            }
            if (index != 0) {
                val prevChar = s[index - 1]
                when {
                    prevChar == 'I' && (char == 'V' || char == 'X') -> result -= 2
                    prevChar == 'X' && (char == 'L' || char == 'C') -> result -= 20
                    prevChar == 'C' && (char == 'D' || char == 'M') -> result -= 200
                }
            }
        }
        return result
    }
}