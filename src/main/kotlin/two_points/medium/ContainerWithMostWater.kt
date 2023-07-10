package two_points.medium

import kotlin.math.max
import kotlin.math.min

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
fun main() {
    println(
        containerWithMostWater(
            intArray = intArrayOf(1,8,6,2,5,4,8,3,7)
        )
    )
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun containerWithMostWater(intArray: IntArray): Int {
    var start = 0
    var end = intArray.size - 1
    var waterArea = 0
    while (start < end) {
        val width = end - start
        val height = min(intArray[start], intArray[end])
        waterArea = max(waterArea, width * height)
        if (intArray[start] < intArray[end]) {
            start++
        } else {
            end--
        }
    }
    return waterArea
}