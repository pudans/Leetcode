package easy

class Solution14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        val targetValue = strs[0]
        var prefixCount = 0
        for (i in targetValue.indices) {
            val ch = targetValue[i]
            var hasPrefix = true
            for (j in 1 until strs.size) {
                hasPrefix = hasPrefix
                        && strs[j].length > i
                        && strs[j][i] == ch
            }

            if (hasPrefix) {
                prefixCount++
            } else {
                break
            }

        }

        return if (prefixCount == 0)
            ""
        else
            targetValue.substring(0, prefixCount)
    }
}