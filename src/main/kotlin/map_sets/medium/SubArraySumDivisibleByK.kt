package map_sets.medium

/**
 * Given an integer array nums and an integer k, return the number of non-empty sub arrays that have a sum divisible by k.
 * A sub array is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 sub arrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * Example 2:
 * Input: nums = [5], k = 9
 * Output: 0
 */
fun main() {
    println(
        subArraySumDivisibleByK(
            nums = intArrayOf(4,5,0,-2,-3,1),
            k = 5
        )
    )
}

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun subArraySumDivisibleByK(nums: IntArray, k: Int): Int {
    var count = 0
    val remMap = mutableMapOf<Int, Int>() // Remainder, Frequency
    remMap[0] = 1
    var rem = 0
    var sum = 0
    for (num in nums) {
        sum += num
        rem = sum % k
        if (rem < 0) {
            rem += k
        }
        if (remMap.containsKey(rem)) {
            remMap[rem]?.let {
                count += it
                remMap[rem] = it + 1
            }
        } else {
            remMap[rem] = 1
        }
    }
    return count
}