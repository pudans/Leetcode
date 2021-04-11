package easy

import java.util.*


class Solution205 {

    val map = HashMap<Char,Char>()
    fun isIsomorphic1(s: String, t: String): Boolean {
        s.forEachIndexed { index, value ->
            map.get(value)?.let {
                if (t[index] != it) {
                    return false
                }
            } ?: kotlin.run {
                map.put(value, t[index])
            }

            map.get(t[index])?.let {
                if (value != it) {
                    return false
                }
            } ?: kotlin.run {
                map.put(t[index], value)
            }
        }
        return true
    }

    fun isIsomorphic(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        val map = HashMap<Char, Char>()
        for (i in 0 until s1.length) {
            if (!map.containsKey(s1[i])) {
                if (map.containsValue(s2[i])) {
                    return false
                } else {
                    map[s1[i]] = s2[i]
                }
            } else {
                if (map[s1[i]] != s2[i]) {
                    return false
                }
            }
        }
        return true
    }
}