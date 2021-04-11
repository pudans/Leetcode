package easy

class Solution283 {

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var j = 0

        while (i < nums.size && j < nums.size) {
            if (nums[j] == 0) {
                j++

                while (j < nums.size) {
                    if (nums[j] != 0) {
                        break;
                    } else {
                        j++
                    }
                }
            }
            if (j < nums.size) {
                nums[i] = nums[j]
                i++
                j++
            }

        }
        if (i < nums.size && j-1 < nums.size) {
            for (g in (i)..(j-1)) {
                nums[g] = 0
            }
        }
    }
}