package easy

class Solution1046 {

    lateinit var stoneList: MutableList<Int>

    fun lastStoneWeight(stones: IntArray): Int {
        stoneList = stones.toMutableList()

        while (stoneList.size > 1) {
            println("-----------")
            println(stoneList.toString())
            findToStones()
        }
        return stoneList.getOrElse(0) { 0 }
    }

    fun findToStones() {
        var stone1Index = 0
        var stone2Index = 1
        if (stoneList.size > 2) {
            for (i in 2 until stoneList.size) {
                if (stoneList[i] > stoneList[stone1Index]) {
                    if (stoneList[stone2Index] < stoneList[stone1Index]) {
                        stone2Index = stone1Index
                    }
                    stone1Index = i
                } else if (stoneList[i] > stoneList[stone2Index]) {
                    stone2Index = i
                }
            }
        }
        println("$stone1Index $stone2Index")
        smashStones(stone1Index, stone2Index)
    }

    fun smashStones(stone1Index: Int, stone2Index: Int) {
        if (stoneList[stone1Index] == stoneList[stone2Index]) {
            if (stone1Index > stone2Index) {
                stoneList.removeAt(stone1Index)
                stoneList.removeAt(stone2Index)
            } else {
                stoneList.removeAt(stone2Index)
                stoneList.removeAt(stone1Index)
            }
        } else if (stoneList[stone1Index] > stoneList[stone2Index]) {
            stoneList[stone1Index] = stoneList[stone1Index] - stoneList[stone2Index]
            stoneList.removeAt(stone2Index)
        } else {
            stoneList[stone2Index] = stoneList[stone2Index] - stoneList[stone1Index]
            stoneList.removeAt(stone1Index)
        }
    }
}