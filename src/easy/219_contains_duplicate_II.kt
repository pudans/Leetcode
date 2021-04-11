package easy

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int,Int>()
        nums.forEachIndexed { index, value ->
            if (map.containsKey(value)) {
                val diff = index - map.get(value)!!
                if (diff <= k) {
                    return true
                }
            }
            map.put(value, index)
        }
        return false
    }
}