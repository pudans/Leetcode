package easy

class Solution67 {

    fun addBinary(a: String, b: String): String {
        var result = ""

        var increase = false

        var aIndex = a.length - 1
        var bIndex = b.length - 1

        while (true) {

            if (aIndex >= 0 && bIndex >= 0) {
                if (a[aIndex] == '1' && b[bIndex] == '1') {
                    if (increase) {
                        result = "1$result"
                    } else {
                        result = "0$result"
                    }
                    aIndex--
                    bIndex--
                    increase = true
                    continue
                }

                if (a[aIndex] == '0' && b[bIndex] == '0') {
                    if (increase) {
                        result = "1$result"
                    } else {
                        result = "0$result"
                    }
                    aIndex--
                    bIndex--
                    increase = false
                    continue
                }

                if (increase) {
                    result = "0$result"
                } else {
                    result = "1$result"
                }
                aIndex--
                bIndex--
                continue
            }

            if (aIndex >= 0) {
                if (a[aIndex] == '1') {
                    if (increase) {
                        result = "0$result"
                    } else {
                        result = "1$result"
                    }
                } else {
                    if (increase) {
                        result = "1$result"
                        increase = false
                    } else {
                        result = "0$result"
                    }
                }
                aIndex--
                continue
            }

            if (bIndex >= 0) {
                if (b[bIndex] == '1') {
                    if (increase) {
                        result = "0$result"
                    } else {
                        result = "1$result"
                    }
                } else {
                    if (increase) {
                        result = "1$result"
                        increase = false
                    } else {
                        result = "0$result"
                    }
                }
                bIndex--
                continue
            }

            if (increase) {
                result = "1$result"
            }
            break
        }
        return result
    }
}