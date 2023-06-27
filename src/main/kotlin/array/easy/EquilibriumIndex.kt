package array.easy

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
 * of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */
fun main() {
    print(equilibriumIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun equilibriumIndex(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var leftSum = 0
    var rightSum = nums.sum()
    nums.forEachIndexed { index, value ->
        rightSum -= value
        if (leftSum == rightSum) {
            return index
        }
        leftSum += value
    }
    return -1
}
