package easy

class Solution53 {

    fun maxSubArray(nums: IntArray): Int {

        var soFar = Int.MIN_VALUE
        var currMax = 0

        nums.forEach {

            if (currMax < 0) {
                currMax = 0
            }

            soFar = Math.max(soFar, currMax + it)

            currMax += it
        }
        return soFar
    }
}