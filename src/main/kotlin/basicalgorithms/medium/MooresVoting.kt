package basicalgorithms.medium

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
fun main() {
    println(
        runMooreAlgorithmMajorityElement(
            intArrayOf(2, 2, 1, 3, 1, 1, 3, 1, 1)
        )
    )
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun runMooreAlgorithmMajorityElement(nums: IntArray): Int {
    var count = 0
    var element = 0
    for (num in nums) {
        if (count == 0) {
            element = num
            count = 1
        } else if (num == element) {
            count++
        } else {
            count--
        }
    }
    var majorityElementCount = 0
    for (num in nums) {
        if (num == element) majorityElementCount++
    }
    if (majorityElementCount > (nums.size / 2)) {
        return element
    }
    return -1
}