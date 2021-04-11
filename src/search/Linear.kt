package search

/**
 * https://proglib.io/p/6-search-algorithms-java
 */

object Linear {

    fun search(array: IntArray, elementToSearch: Int): Int {
        for (index in array.indices) {
            if (array[index] == elementToSearch) {
                return index
            }
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val index: Int = search(intArrayOf(89, 57, 91, 47, 95, 3, 27, 22, 67, 99), 67)
        println(index)
    }
}