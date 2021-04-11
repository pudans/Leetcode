package easy

class Solution263 {

    fun isUgly(num: Int): Boolean {
        if (num <= 0) {
            return false
        }
        if (num == 1) {
            return true
        }
        if (num % 2 == 0) {
            return isUgly(num / 2)
        }
        if (num % 3 == 0) {
            return isUgly(num / 3)
        }
        if (num % 5 == 0) {
            return isUgly(num / 5)
        }
        return false
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val d = Solution263()

            for (i in 1 .. 100) {
                println("$i = ${d.isUgly(i)}")
            }

        }
    }
}