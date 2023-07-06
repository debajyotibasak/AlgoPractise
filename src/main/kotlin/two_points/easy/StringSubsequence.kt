package two_points.easy

/**
 * You have been given two strings 'STR1 and 'STR2.
 * Your task is to find if 'STR1' is a subsequence of 'STR2.
 * A subsequence of a string is a new string that can be derived from the original string by deleting some characters
 * (can be none) without changing the relative ordering of other characters.
 * Example:
 * 'ACE' is a subsequence of 'ABCDE' because 'ACE' can be formed by deleting 'B' and 'D' without changing the relative
 * order of characters. 'ADB' is not a subsequence of 'ABCDE' because we can get ABD' from 'ABCDE' but not
 * "ADB' and in 'ADB' relative order of 'B' and 'D' are different from original strings.
 *
 * Note:
 * 1. Strings 'STRI' and ' STR2' consists only of English uppercases.
 * 2. Length of string 'STR2' will always be greater than or equal to the length of string 'STRI'
 */
fun main() {
    println(
        isSubsequence(
            str1 = "ABC",
            str2 = "AHBDGC"
        )
    )
}

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
private fun isSubsequence(str1: String, str2: String): Boolean {
    var pointer1 = 0
    for (character in str2) {
        if (character == str1[pointer1]) {
            if (pointer1 == str1.length - 1) {
                return true
            } else {
                pointer1++
            }
        }
    }
    return false
}