
object Sort {

    object Bubble {

        fun sort(array: IntArray) {
            for (i in 0 until array.size - 1) {
                for (j in (i + 1) until array.size) {
                    if (array[j] < array[i]) {
                        val temp = array[j]
                        array[j] = array[i]
                        array[i] = temp
                    }
                }
            }
        }
    }

    /**
     * https://www.geeksforgeeks.org/insertion-sort/
     */

    object Insertion {

        fun sort(array: IntArray) {
            for (i in 1 until array.size) {
                val key = array[i]
                var j = i - 1
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j]
                    j--
                }
                array[j + 1] = key
            }
        }
    }


    /**
     * https://www.geeksforgeeks.org/merge-sort/?ref=lbp
     */

    object Merge {

        private fun merge(arr: IntArray, left: Int, middle: Int, right: Int) {
            // Find sizes of two subarrays to be merged
            val n1 = middle - left + 1
            val n2 = right - middle

            /* Create temp arrays */
            val L = IntArray(n1) { arr[left + it] }
            val R = IntArray(n2) { arr[middle + 1 + it] }

            // Initial indexes of first and second subarrays
            var i = 0
            var j = 0

            // Initial index of merged subarry array
            var k = left
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i]
                    i++
                } else {
                    arr[k] = R[j]
                    j++
                }
                k++
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i]
                i++
                k++
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j]
                j++
                k++
            }
        }

        // Main function that sorts arr[l..r] using
        // merge()
        fun sort(arr: IntArray, left: Int, right: Int) {
            if (left < right) {
                // Find the middle point
                val middle = left + (right - left) / 2

                // Sort first and second halves
                sort(arr, left, middle)
                sort(arr, middle + 1, right)

                // Merge the sorted halves
                merge(arr, left, middle, right)
            }
        }
    }


    /**
     * https://www.geeksforgeeks.org/quick-sort/?ref=lbp
     */

    object Quick {

        fun sort(arr: IntArray, low: Int, high: Int) {
            if (low < high) {
                /* pi is partitioning index, arr[p] is now  at right place */
                val pi: Int = partition(arr, low, high)

                // Separately sort elements before
                // partition and after partition
                sort(arr, low, pi - 1)
                sort(arr, pi + 1, high)
            }
        }

        private fun partition(array: IntArray, low: Int, high: Int): Int {
            val pivot = array[high] // pivot
            var i = (low - 1) // Index of smaller element and indicates the right position of pivot found so far
            for (j in low until high) {
                // If current element is smaller than the pivot
                if (array[j] < pivot) {
                    i++; // increment index of smaller element
                    val temp = array[j]
                    array[j] = array[i]
                    array[i] = temp
                }
            }
            val temp = array[i+1]
            array[i+1] = array[high]
            array[high] = temp
            return (i + 1)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(3, 60, 35, 2, 45, 320, 5)
        Quick.sort(arr, 0, arr.size - 1)
        println(arr.toList())

        arr.shuffle()
        Insertion.sort(arr)
        println(arr.toList())

        arr.shuffle()
        Bubble.sort(arr)
        println(arr.toList())

        arr.shuffle()
        Merge.sort(arr, 0, arr.size - 1)
        println(arr.toList())
    }

}