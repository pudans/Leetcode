package easy

class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = HashSet<Int>()
        nums.forEach {
            if (map.contains(it)) {
                return true
            } else {
                map.add(it)
            }
        }
        return false
    }
}