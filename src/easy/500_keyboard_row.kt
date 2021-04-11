package easy

class Solution500 {

    val map = mapOf<Char, Int>(
            'q' to 1, 'w' to 1, 'e' to 1, 'r' to 1, 't' to 1, 'y' to 1, 'u' to 1, 'i' to 1, 'o' to 1, 'p' to 1,
            'a' to 2, 's' to 2, 'd' to 2, 'f' to 2, 'g' to 2, 'h' to 2, 'j' to 2, 'k' to 2, 'l' to 2,
            'z' to 3, 'x' to 3, 'c' to 3, 'v' to 3, 'b' to 3, 'n' to 3, 'm' to 3
    )

    fun findWords(words: Array<String>): Array<String> {
        val result = ArrayList<String>()
        for (j in 0 until words.size) {
            if (isValid(words.get(j))) {
                result.add(words.get(j))
            }
        }
        return result.toTypedArray()
    }

    fun isValid(word: String): Boolean {
        val firstChar = map[word.first().toLowerCase()]
        for (i in 1 until word.length) {
            if (map[word[i].toLowerCase()] != firstChar) {
                return false
            }
        }
        return true
    }
}