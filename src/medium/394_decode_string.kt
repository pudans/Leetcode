package medium

import java.lang.StringBuilder

class Solution394 {

    fun decodeString(str: String): String {
        println(str)

        val result = StringBuilder()

        var number = 0
        var i = 0
        while (i < str.length) {
            when {
                str[i].isDigit() && number != 0 -> number = number * 10 + (str[i] - '0')
                str[i].isDigit() -> number = str[i] - '0'
                str[i] == '[' -> {

                    val closeBreak = findCloseBreak(i, str)
                    val substring = str.substring(i + 1, closeBreak)
                    val detekt = decodeString(substring)
                    println("catch! $number $substring $detekt")
                    for (j in 1..number) {
                        result.append(detekt)
                    }
                    i = closeBreak
                    number = 0
                }
                str[i] == ']' -> {
                    println("error asd")
                }
                else -> result.append(str[i])
            }
            i++
        }

        return result.toString()
    }

    fun findCloseBreak(start: Int, str: String): Int {
        var openedBreakes = 0
        for (i in (start + 1) until str.length) {
            when {
                str[i] == '[' -> openedBreakes++
                str[i] == ']' && openedBreakes != 0 -> openedBreakes--
                str[i] == ']' -> return i
            }
        }
        println("error vvv")
        return -1
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val dd = Solution394().decodeString("3[a2[c]]")
            println(dd)
        }
    }
}