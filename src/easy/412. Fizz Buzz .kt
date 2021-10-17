package easy

/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i if non of the above conditions are true.
 */

class Easy412 {

    fun fizzBuzz(n: Int): List<String> {
        val result = ArrayList<String>()
        for (i in 1..n) {
            val mult3 = i % 3 == 0
            val mult5 = i % 5 == 0
            result.add(
                when {
                    mult3 && mult5 -> "FizzBuzz"
                    mult5 -> "Buzz"
                    mult3 -> "Fizz"
                    else -> i.toString()
                }
            )
        }
        return result
    }
}

fun main() {
    println(Easy412().fizzBuzz(3))
    println(Easy412().fizzBuzz(5))
    println(Easy412().fizzBuzz(15))
}