package easy

import java.util.*

class Solution387 {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char,Int>()
        val indexies = mutableMapOf<Char,Int>()

        s.forEachIndexed { index, c ->
            map.set(c, map.getOrDefault(c, 0) + 1)
            indexies.set(c, index)
        }

        val targetKey = map.keys.find { map[it] == 1 }
        if (targetKey == null) {
            return -1
        } else {
            return indexies[targetKey]!!
        }
    }
}