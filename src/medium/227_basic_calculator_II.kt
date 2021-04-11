package medium

class Solution227 {

    val numbers = ArrayList<Int>()
    val signs = ArrayList<Char>()

    fun calculate(s: String): Int {
        val str = s.filter { it != ' ' }
        var lastSign = -1
        for (i in str.indices) {
            if (!str[i].isDigit()) {
                signs.add(str[i])
                val num = str.substring(lastSign + 1, i)
                println("$i ${str[i]} $lastSign $num")

                numbers.add(num.toInt())
                lastSign = i
            }
            if (i == s.length - 1) {
                val num = s.substring(lastSign + 1)
                numbers.add(num.toInt())
            }
        }

        var index = signs.indexOfFirst { it == '*' || it == '/' }
        while (index >= 0) {
            go(index)
            index = signs.indexOfFirst { it == '*' || it == '/' }
        }

        while (signs.isNotEmpty()) {
            go(0)
        }
        return numbers[0]
    }

    fun go(index: Int) {
        val sign = signs[index]
        val a = numbers[index]
        val b = numbers[index + 1]
        val result = when(sign) {
            '*' -> a * b
            '/' -> a / b
            '-' -> a - b
            else -> a + b
        }
        numbers[index] = result
        numbers.removeAt(index + 1)
        signs.removeAt(index)
    }


    companion object {

        @JvmStatic
        fun main(vararg args: String) {
            println(Solution227().calculate("3+2*2"))
        }

    }
}