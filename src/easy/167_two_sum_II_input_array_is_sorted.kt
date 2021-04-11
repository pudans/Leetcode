package easy

class Solution167 {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0..(numbers.size - 2)) {
            val first = numbers[i]
            for (j in (i + 1) until numbers.size) {
                val second = numbers[j]
                if (second + first == target) {
                    return intArrayOf(i + 1,j + 1)
                }
                if (first + second > target) {
                    break
                }
            }
        }
        return intArrayOf(0,0)
    }
}