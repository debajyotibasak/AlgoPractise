package map_sets.medium

import kotlin.math.max

/**
 * Find the longest length of sub-array whose sum is 0
 *
 * Input: [1, 3, -1, 4, -4] Output: 2
 * Input: [1, 2, 1, -2] Output: 0
 * Input: [1, -1, 2, -2] Output: 4
 * Input: [4, -5, 1] Output: 3
 * Input: [1, 3, -1, 4, -4] Output: 2
 * Input: [0, 1] Output: 1
 * Input: [0, 1, -1] Output: 3
 */
fun main() {
    println(longestSubSetWithZero(numList = listOf(0, 1, -1)))
}

/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
private fun longestSubSetWithZero(numList: List<Int>): Int {
    val preSum = mutableMapOf<Int, Int>()
    var sum = 0
    var maxLength = 0
    numList.forEachIndexed { index, value ->
        sum += value

        if (value == 0 && maxLength == 0) {
            maxLength = 1
        } else if (sum == 0) {
            maxLength = index + 1
        }

        if (preSum.containsKey(sum)) {
            preSum[sum]?.let {
                maxLength = max(maxLength, index - it)
            }
        } else {
            preSum[sum] = index
        }
    }
    return maxLength
}