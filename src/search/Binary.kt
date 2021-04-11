package search


/**
 * https://proglib.io/p/6-search-algorithms-java
 */

object Binary {

    // iterative
    fun searchIterative(arr: IntArray, elementToSearch: Int): Int {
        var firstIndex = 0
        var lastIndex = arr.size - 1

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            val middleIndex = (firstIndex + lastIndex) / 2
            println("$firstIndex $lastIndex $middleIndex")
            // если средний элемент - целевой элемент, вернуть его индекс
            when {
                arr[middleIndex] == elementToSearch -> {
                    return middleIndex
                }
                arr[middleIndex] < elementToSearch -> {
                    firstIndex = middleIndex + 1
                }
                arr[middleIndex] > elementToSearch -> {
                    lastIndex = middleIndex - 1
                }
            }
        }
        return -1
    }

    // recursive
    fun searchRecursive(arr: IntArray, firstElement: Int, lastElement: Int, elementToSearch: Int): Int {

        // условие прекращения
        if (lastElement >= firstElement) {
            val mid = firstElement + (lastElement - firstElement) / 2
            println("$firstElement $lastElement $mid")
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch) {
                return mid
            }

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            return if (arr[mid] > elementToSearch) {
                searchRecursive(arr, firstElement, mid - 1, elementToSearch)
            } else {
                searchRecursive(arr, mid + 1, lastElement, elementToSearch)
            }
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(89, 57, 91, 47, 95, 3, 27, 22, 67, 99)
        Sort.Bubble.sort(array)
        println(array.toList())
        val index1 = searchIterative(array, 67)
        println("searchIterative = $index1")

        val index2 = searchRecursive(array, 0, array.size - 1, 67)
        println("searchRecursive = $index2")
    }
}