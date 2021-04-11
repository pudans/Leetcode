package medium

class Solution78 {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val n = Math.pow(2.0, nums.size.toDouble()).toInt()
        for (i in 0 until n) {
            val str = Integer.toBinaryString(i)
            val res = ArrayList<Int>()

            for (j in nums.indices) {
                if (nums.size - j > str.length) {

                } else {
                    if (str[j - (nums.size - str.length)] == '1') {
                        res.add(nums[j])
                    }
                }
            }
            println(str)
            result.add(res)
        }
        return result
    }
}