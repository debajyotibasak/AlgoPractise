package basicalgorithms.easy

/**
 * Insertion sort algorithm
 */
fun main() {
    println(insertionSort(mutableListOf(90, 80, 70, 60, 40, 20, 0)))
}

/**
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
private fun insertionSort(array: MutableList<Int>): MutableList<Int> {
    for (index in 1..array.lastIndex) {
        val key = array[index] // pivot card
        var i = index - 1 // last sorted position
        while (i >= 0 && array[i] > key) {
            array[i + 1] = array[i]
            i--
        }
        array[i + 1] = key
    }
    return array
}