package easy

class Solution412 {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()

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