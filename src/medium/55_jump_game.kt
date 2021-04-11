package medium

class Solution55 {

    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return true
        }
        if (nums.size == 2) {
            return nums[0] > 0
        }
        val res = BooleanArray(nums.size)
        res[0] = true

        for (i in 0..(nums.size - 2)) {
            if (res[i]) {
                var j = i + 1
                while (j < nums.size && j < (i + 1 + nums[i])) {
                    res[j] = true
                    j++
                }
            }
        }
        println(res.toList())
        return res[nums.size - 1]
    }
}