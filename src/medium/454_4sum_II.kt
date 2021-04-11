package medium

class Solution454 {

    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var result = 0

        val map = HashMap<Int,Int>()
        A.forEach { a ->
            B.forEach { b ->
                val key = a + b
                map.set(key, map.getOrDefault(key, 0) + 1)
            }
        }

        C.forEach { c ->
            D.forEach { d ->
                val key = -(c + d)
                if (map.containsKey(key)) {
                    result += map.get(key)!!
                }
            }
        }

        return result
    }
}