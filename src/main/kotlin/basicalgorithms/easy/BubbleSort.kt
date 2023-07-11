package basicalgorithms.easy

/**
 * Sorting using Bubble Sort
 */
fun main() {
    println(bubbleSort(mutableListOf(64, 25, 22, 11)))
}

/**
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 */
private fun bubbleSort(array: MutableList<Int>): MutableList<Int> {
    for (i in 0..array.lastIndex) {
        for (j in array.lastIndex downTo i + 1) {
            if (array[j] < array[j - 1]) {
                swapNumbers(array, j, j - 1)
            }
        }
    }
    return array
}

private fun swapNumbers(array: MutableList<Int>, index: Int, minIndex: Int) {
    val temp = array[index]
    array[index] = array[minIndex]
    array[minIndex] = temp
}