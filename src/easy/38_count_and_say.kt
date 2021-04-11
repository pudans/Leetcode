package easy

class Solution38 {

    fun countAndSay(input: Int): String {
        if (input == 1) return "1"
        if (input == 2) return "11"
        if (input == 3) return "21"
        if (input == 4) return "1211"
        if (input == 5) return "111221"
        val sb = StringBuilder()

        val prevOutput = countAndSay(input - 1)
        // 1211 111221
        var count = 1
        for (i in 0 until prevOutput.length - 1) {
            if (prevOutput[i] == prevOutput[i + 1]) {
                count++
            } else {
                sb.append(count).append(prevOutput[i])
                count = 1
            }
        }
        sb.append(count).append(prevOutput[prevOutput.length - 1])
        return sb.toString()
    }
}