package easy

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

class Easy387 {

    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char, Int>()
        val indexies = HashMap<Char, Int>()

        s.forEachIndexed { index, c ->
            map[c] = map.getOrDefault(c, 0) + 1
            indexies[c] = index
        }

        val targetKey = map.keys.find { map[it] == 1 }
        return if (targetKey == null) {
            -1
        } else {
            indexies[targetKey]!!
        }
    }
}

fun main() {
    println(Easy387().firstUniqChar("leetcode"))
    println(Easy387().firstUniqChar("loveleetcode"))
    println(Easy387().firstUniqChar("aabb"))
}