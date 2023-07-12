package mixedbasic

/**
 * Find intersection of sorted non-decreasing array
 * Input
 * arr1: [1,2,3,4]
 * arr2: [3,4,5,5]
 * Output:
 * [3,4]
 */
fun main() {
    println(
        findIntersectionArray(
            arr1 = listOf(1,2,3,4),
            arr2 = listOf(3,4,5,5)
        )
    )
}

/**
 * Time complexity : O(m+n) where m and n is no of characters in arr1 and arr2 respectively
 * Space complexity : O(1)
 */
private fun findIntersectionArray(arr1: List<Int>, arr2: List<Int>): MutableList<Int> {
    var i = 0
    var j = 0
    val intersectionArray = mutableListOf<Int>()
    while (i <= arr1.size - 1 && j <= arr2.size - 1) {
        if (arr1[i] == arr2[j]) {
            intersectionArray.add(arr1[i])
            i++
            j++
        } else if (arr1[i] < arr2[j]) {
            i++
        } else if (arr1[i] > arr2[j]) {
            j++
        }
    }
    if (intersectionArray.isEmpty()) intersectionArray.add(-1)
    return intersectionArray
}