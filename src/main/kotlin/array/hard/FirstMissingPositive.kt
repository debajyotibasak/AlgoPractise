package array.hard

import kotlin.math.abs

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 * Video: https://www.youtube.com/watch?v=QeBvfH1dpOU&ab_channel=Pepcoding
 */
fun main() {
    print(firstMissingPositive(intArrayOf(3, 2, -6, 1, 0)))
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun firstMissingPositive(nums: IntArray): Int {
    var isOnePresent = false
    val sizeOfArray = nums.size
    // Mark the element out of range with 1 and find if 1 is present
    for (index in 0 until sizeOfArray) {
        if (nums[index] == 1)
            isOnePresent = true
        if (nums[index] < 1 || nums.size < nums[index])
            nums[index] = 1
    }
    if (isOnePresent.not()) return 1
    // Map the elements using index
    for (i in 0 until sizeOfArray) {
        val index = abs(nums[i])
        nums[index - 1] = -abs(nums[index - 1])
    }
    // Find the missing first positive number
    for (i in 0 until sizeOfArray) {
        if (nums[i] > 0) return i + 1
    }
    return sizeOfArray + 1
}