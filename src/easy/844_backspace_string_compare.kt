package easy

class Solution844 {

    fun backspaceCompare1(S: String, T: String): Boolean {

        var i = 0
        var j = 0

        var strA = S
        var strB = T

        while (i < strA.length || j < strB.length) {

            if (i < strA.length) {
                if (strA[i] == '#') {
                    if (i != 0) {
                        strA = strA.replaceRange(IntRange(i-1,i),"")
                        i--
                    } else {
                        strA = strA.replaceRange(IntRange(i,i),"")
                    }
                } else {
                    i++
                }
            }

            if (j < strB.length) {
                if (strB[j] == '#') {
                    if (j != 0) {
                        strB = strB.replaceRange(IntRange(j-1,j),"")
                        j--
                    } else {
                        strB = strB.replaceRange(IntRange(j,j),"")
                    }
                } else {
                    j++
                }
            }
        }
        println(strA)
        println(strB)
        return strA == strB
    }
}