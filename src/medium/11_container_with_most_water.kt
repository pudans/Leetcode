package medium

class Solution11 {

    fun maxArea(height: IntArray): Int {
        var result = 0
        for (i in 0 until height.size - 1) {
            for (j in i + 1 until height.size) {
                val res = Math.min(height[i],height[j]) * (j - i)
                if (res > result) {
                    result = res
                }
            }
        }
        return result
    }
}