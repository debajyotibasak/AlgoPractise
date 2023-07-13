package mixedbasic

/**
 * Find union of sorted non-decreasing array
 * Input
 * arr1: [1,2,3,4]
 * arr2: [3,4,5,5]
 * Output:
 * [1,2,3,4,5,5]
 */
fun main() {
    println(
        findUnionArray(
            arr1 = listOf(1, 2, 3, 4, 5, 6),
            arr2 = listOf(5, 6, 7, 8)
        )
    )
}

/**
 * Time complexity : O(m+n) where m and n is no of characters in arr1 and arr2 respectively
 * Space complexity : O(m+n) just for storing the answer and displaying
 */
private fun findUnionArray(arr1: List<Int>, arr2: List<Int>): MutableList<Int> {
    val arr1Length = arr1.size
    val arr2Length = arr2.size
    var i = 0
    var j = 0
    val unionArray = mutableListOf<Int>()
    while (i < arr1Length && j < arr2Length) {
        if (arr1[i] < arr2[j]) {
            unionArray.add(arr1[i])
            i++
        } else if (arr1[i] > arr2[j]) {
            unionArray.add(arr2[j])
            j++
        } else if (arr1[i] == arr2[j]) {
            unionArray.add(arr1[i])
            i++
            j++
        }
    }
    while (i < arr1Length) {
        unionArray.add(arr1[i])
        i++
    }
    while (j < arr2Length) {
        unionArray.add(arr2[j])
        j++
    }
    return unionArray
}