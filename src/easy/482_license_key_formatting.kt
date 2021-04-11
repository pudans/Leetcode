package easy

import java.lang.StringBuilder

class Solution482 {

    fun licenseKeyFormatting(S: String, K: Int): String {
        var result = StringBuilder(S.filter { it != '-' }.toUpperCase())
        if (result.length <= K) {
            return result.toString()
        }

        val firstDash = result.length % K
        var i = firstDash + K
        if (firstDash != 0) {
            result.insert(firstDash, '-')
            i++
        }
        while (i < result.length) {
            result.insert(i, '-')
            i += K + 1
        }
        return result.toString()
    }
}