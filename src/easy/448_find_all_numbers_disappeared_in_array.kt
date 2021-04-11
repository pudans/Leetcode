package easy

class Solution448 {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = IntArray(nums.size) {
            return@IntArray it + 1
        }

        nums.forEach {
            result[it - 1] = - 1
        }

        return result.filter { it > 0 }
    }
}