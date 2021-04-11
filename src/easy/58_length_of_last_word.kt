package easy

class Solution58 {

    fun lengthOfLastWord(s: String): Int {
        val targetStr = s.trim()
        if (targetStr.isEmpty()) {
            return 0
        }
        for (i in (targetStr.length - 1) downTo 0) {
            if (targetStr[i] == ' ') {
                return targetStr.length - 1 - i
            }
        }
        return targetStr.length
    }
}