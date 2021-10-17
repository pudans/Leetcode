package easy

class Solution389 {

    fun findTheDifference(s: String, t: String): Char {
        var sum = 0
        s.forEachIndexed { index, value ->
            sum -= value.toInt()
            sum += t[index].toInt()
            println("$sum add $value ${value.toInt()} not ${t[index]} ${t[index].toInt()}" )
        }
        sum += t[t.length - 1].toInt()
        println("$sum add ${t[t.length - 1]} ${t[t.length - 1].toInt()}" )
        return sum.toChar()
    }
}