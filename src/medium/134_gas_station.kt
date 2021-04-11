package medium

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val size = gas.size
        for (i in gas.indices) {
            // print("||$i ")
            if (gas[i] < cost[i]) {
                continue
            }
            var currGas = gas[i]
            // print("init=$currGas ")
            for (j in i..(i + size)) {
                if (j == i + size) {
                    return i
                }
                val index = if (j > size - 1) j - size else j
                if (i != j) {
                    currGas += gas[index]
                }
                // print("$currGas $j-$index ")
                if (cost[index] > currGas) {
                    break
                } else {
                    currGas -= cost[index]
                }
            }

        }
        // println()

        return -1
    }
}