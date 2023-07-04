package map_sets.easy

/**
 * You are given an array 'array' of size n, and you have to tell the minimum number of elements that need to be removed
 * such that the array contains all distinct elements. More formally, there should not be any 'i' and 'j' such
 * that 'i'!= 'j' and array['i'] != array['j'].
 * For example:
 * Given 'n' = 4,
 * 'array' = {1, 2, 1, 2}
 * Then the answer is 2 because 1 and 2 are repeated once therefore we need to remove 2 elements.
 */
fun main() {
    println(minElementsToRemove(listOf(1, 2, 3, 1, 2, 1, 1, 2)))
}

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun minElementsToRemove(numList: List<Int>): Int {
    val map = mutableMapOf<Int, Boolean>()
    var elementsToRemove = 0
    for (num in numList) {
        if (map.containsKey(num).not()) {
            map[num] = true
        } else {
            elementsToRemove++
        }
    }
    return elementsToRemove
}