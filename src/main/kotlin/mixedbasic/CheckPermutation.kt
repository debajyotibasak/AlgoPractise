package mixedbasic

/**
 * You have been given two strings 'STR1' and 'STR2' You have to check whether the two strings are anagram to each
 * other or not.
 *
 * Note: Two strings are said to be anagram if they contain the same characters, irrespective of the order of the
 * characters.
 *
 * Example:
 * If 'STR1' = "listen" and 'STR2' = "silent" then the
 * output will be 1.
 * Both the strings contain the same set of characters.
 */
fun main() {
    print(checkPermutation(str1 = "listen", str2 = "silent"))
}

/**
 * Time complexity: O(n) Avg lookup in case of hashmap in O(1)
 * Space complexity: O(k) k=52 which is constant because there can be 26 lowercase and 26 uppercase characters
 *
 */
private fun checkPermutation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    val characterOccurrenceMap = mutableMapOf<Char, Int>()
    for (character in str1) {
        characterOccurrenceMap[character] =
            characterOccurrenceMap[character]?.plus(1) ?: 1
    }
    for (character in str2) {
        if (characterOccurrenceMap.containsKey(character)) {
            characterOccurrenceMap[character] =
                characterOccurrenceMap[character]!!.minus(1)
        } else {
            return false
        }
    }
    return characterOccurrenceMap.values.any { it > 0 }.not()
}