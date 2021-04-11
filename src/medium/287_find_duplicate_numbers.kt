package medium

class Solution287 {

    fun findDuplicate(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val map = HashMap<Int,Int>()
        nums.forEach {
            if (map.getOrDefault(it, 0) == 1) {
                return it
            } else {
                map.set(it, 1)
            }
        }
        return 0
    }
}