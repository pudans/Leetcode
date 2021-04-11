package easy

class Solution414 {

    fun thirdMax(nums: IntArray): Int {
        val result = arrayOfNulls<Int>(3)

        nums.forEach {
            when {
                it == result[0] -> {}
                result[0] == null || it > result[0]!! -> {
                    result[2] = result[1]
                    result[1] = result[0]
                    result[0] = it
                }
                it == result[1] -> {}
                result[1] == null || it > result[1]!! -> {
                    result[2] = result[1]
                    result[1] = it
                }
                result[2] == null || it > result[2]!! -> {
                    result[2] = it
                }
            }
        }
        println(result.asList().toString())
        return if (result[2] != null) result[2]!! else result[0]!!
    }
}