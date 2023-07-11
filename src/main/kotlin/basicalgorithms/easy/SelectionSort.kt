package basicalgorithms.easy

/**
 * Sort array using selection sort
 */
fun main() {
    println(selectionSort(mutableListOf(64,25,22,11)))
}

/**
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 */
private fun selectionSort(array: MutableList<Int>): MutableList<Int> {
    var minIndex = 0
    for (index in 0 until array.lastIndex) {
        minIndex = index
        for (newIndex in index + 1..array.lastIndex) {
            if (array[newIndex] < array[minIndex]) {
                minIndex = newIndex
            }
        }
        swapNumbers(array, index, minIndex)
    }
    return array
}

private fun swapNumbers(array: MutableList<Int>, index: Int, minIndex: Int) {
    val temp = array[index]
    array[index] = array[minIndex]
    array[minIndex] = temp
}

