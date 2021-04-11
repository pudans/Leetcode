package easy

class Solution169 {

    fun majorityElement(nums: IntArray): Int {
        var maxCount = 0
        var maxValue = 0
        val map = HashMap<Int,Int>()
        nums.forEach {
            val value = map.getOrDefault(it, 0) + 1
            map.put(it, value)

            if (value > maxCount) {
                maxCount = value
                maxValue = it
            }
        }
        return maxValue
    }
}