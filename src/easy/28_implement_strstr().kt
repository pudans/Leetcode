package easy

class Solution28 {

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        for (i in 0..haystack.length - needle.length) {
            var has = true
            for (j in needle.indices) {
                has = has && haystack[i+j] == needle[j]
            }
            if (has) {
                return i
            }
        }
        return -1
    }
}