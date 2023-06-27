package array.medium

/**
 * Given an array of numbers, Rotate the array by k places to the right
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
fun main() {
    println(rotate(intArrayOf(1,2,3,4,5,6,7), 3))
}

/**
 * O(n) Time | O(1) Space
 * */
private fun rotate(nums: IntArray, k: Int): List<Int> {
    val placesToRotate = k % nums.size
    reverseArray(nums, 0, nums.size - 1)
    reverseArray(nums, 0, placesToRotate - 1)
    reverseArray(nums, placesToRotate, nums.size - 1)
    return nums.toList()
}

private fun reverseArray(nums: IntArray, startIndex: Int, endIndex: Int) {
    var start = startIndex
    var end = endIndex
    while (start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}