package two_points.easy

/**
 * You are given an array 'ARR' consisting of 'N' integers. You need to rearrange the array elements such that all
 * negative numbers appear before all positive numbers.
 * Follow Up:
 * Can you solve this in O(1) auxiliary space?
 * Note:
 * The order of elements in the resulting array is not important.
 *
 * Example:
 * Let the array be [1, 2, -3, 4, -4, -5]. On rearranging
 * the array such that all negative numbers appear before all positive numbers we get the resulting array
 * [-3, -5, -4, 2, 4, 1].
 */
fun main() {
    println(moveNegativeNumbersToStart(mutableListOf(1, 2, -3, 4, -4, -5)))
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun moveNegativeNumbersToStart(nums: MutableList<Int>): MutableList<Int> {
    var positiveIndex = 0
    nums.forEachIndexed { index, value ->
        if (value < 0) {
            val temp = nums[positiveIndex]
            nums[positiveIndex] = nums[index]
            nums[index] = temp
            positiveIndex++
        }
    }
    return nums
}

