package array.easy

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing
 * by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based)
 * such that (0 <= i <= n - 2).
 */
fun main() {
    println(isNonDecreasingArray(nums = intArrayOf(4, 2, 1)))
}

/**
 * O(n) Time | O(1) Space
 * */
private fun isNonDecreasingArray(nums: IntArray): Boolean {
    var position = -1 // Position to be modified
    for (index in 0 until nums.lastIndex) {
        if (nums[index] > nums[index + 1]) {
            if (position != -1) return false // If position is modified before
            position = index
        }
    }
    return (position == -1)  // If position is not changed then array is non-decreasing
            || (position == 0) // If first position only need to be modified
            || (position == nums.lastIndex - 1) // If second last position needs to be modified
            // If the previous position is less or equal to the next position
            || (nums[position - 1] <= nums[position + 1])
            // If the position is less than or equal to position+2
            || (nums[position] <= nums[position + 2])
}