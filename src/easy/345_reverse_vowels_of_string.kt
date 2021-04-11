package easy

class Solution345 {

    fun reverseVowels(s: String): String {

        var i = 0
        var j = s.length - 1
        var leftVowelIndex = -1
        val result = s.toCharArray()
        while (i <= j) {

            if (leftVowelIndex < 0) {
                if (result[i].isVowel()) {
                    leftVowelIndex = i
                }
                i++
            } else {
                if (result[j].isVowel()) {
                    val temp = result[leftVowelIndex]
                    result[leftVowelIndex] = result[j]
                    result[j] = temp
                    leftVowelIndex = -1
                }
                j--
            }
        }
        return String(result)
    }

    fun Char.isVowel(): Boolean =
            this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u' ||
                    this == 'A' || this == 'E' || this == 'I' || this == 'O' || this == 'U'
}