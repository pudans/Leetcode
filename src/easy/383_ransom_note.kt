package easy

class Solution383 {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.isEmpty()) {
            return true
        }
        if (magazine.length < ransomNote.length) {
            return false
        }

        val map = HashMap<Char,Int>()
        magazine.forEachIndexed { index, value ->
            map.set(value, map.getOrDefault(value, 0) + 1)
            if (index < ransomNote.length) {
                map.set(ransomNote[index], map.getOrDefault(ransomNote[index], 0) - 1)
            }
        }
        map.values.forEach {
            if (it < 0) {
                return false
            }
        }
        return true
    }
}