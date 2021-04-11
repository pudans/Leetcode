package easy

class Solution485 {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var currResult = 0

        nums.forEach {
            if (it == 1) {
                currResult++
            } else {
                if (currResult > result) {
                    result = currResult
                }
                currResult = 0
            }
        }
        if (currResult > result) {
            result = currResult
        }
        return result
    }
}