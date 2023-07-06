package two_points.easy

/**
 * You are given an array/list 'ARR' consisting of 'N' distinct integers arranged in ascending order.
 * You are also given an integer 'TARGET'. Your task is to count all the distinct pairs in 'ARR' such that their sum is
 * equal to 'TARGET'
 * Note:
 * 1. Pair (x,y) and Pair (y,x) are considered as the same pair.
 * 2. If there exists no such pair with sum equals to 'TARGET', then return -1.
 *
 * Example:
 * Let 'ARR' = [1 2 3] and 'TARGET = 4. Then, there exists
 * only one pair in 'ARR' with a sum of 4 which is (1, 3).
 * (1, 3) and (3, 1) are counted as only one pair.
 */
fun main() {
    println(
        pairSum(
            nums = listOf(1, 3, 5, 6),
            target = 10
        )
    )
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
private fun pairSum(nums: List<Int>, target: Int): Int {
    var startIndex = 0
    var endIndex = nums.size - 1
    var pairSumCount = 0
    while (startIndex < endIndex) {
        val sum = nums[startIndex] + nums[endIndex]
        if (sum > target) {
            endIndex--
        } else if (sum < target) {
            startIndex++
        } else {
            pairSumCount++
            endIndex--
            startIndex++
        }
    }
    if (pairSumCount == 0)
        return -1
    return pairSumCount
}