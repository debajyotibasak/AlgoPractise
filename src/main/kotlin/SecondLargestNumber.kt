import SecondLargestNumber.secondLargestNumber

/**
 * Given an array of numbers, find the 2nd Largest Number
 */
fun main() {
    println(secondLargestNumber(listOf(6, 5, 1, -2, 6, 8, 8)))
}

object SecondLargestNumber {
    /**
     * O(n) Time | O(1) Space
     * */
    fun secondLargestNumber(numList: List<Int>): Int {
        var largestNumber = Int.MIN_VALUE
        var secondLargestNumber = Int.MIN_VALUE
        if (numList.size < 2) {
            throw IllegalArgumentException("Invalid Input")
        }
        for (num in numList) {
            if (num > largestNumber) {
                secondLargestNumber = largestNumber
                largestNumber = num
            } else if (num < largestNumber && num > secondLargestNumber) {
                secondLargestNumber = num
            }
        }
        if (secondLargestNumber == Int.MIN_VALUE) {
            throw IllegalArgumentException("Invalid Input")
        }
        return secondLargestNumber
    }
}
