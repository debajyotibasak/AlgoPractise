package map_sets.easy

/**
 * Return the first unique character in the string.
 * The string will contain characters only from the English alphabet set, i.e., ('A' - 'Z') and ('a' - 'z').
 * If there is no non-repeating character, print the first character of the string.
 *
 * Input:
 * aDcadhc
 * Output:
 * D
 */
fun main() {
    println(firstNonRepeatingCharacter("aDcadhc"))
}

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Because lowercase and uppercase english alphabets are (26+26 = 52 characters) and
 * it cannot increase more than that hence its constant
 */
fun firstNonRepeatingCharacter(string: String): Char {
    val charOccurrences = mutableMapOf<Char, Int>()
    for (char in string) {
        charOccurrences[char] = charOccurrences[char]?.plus(1) ?: 1
    }
    string.forEachIndexed { _, character ->
        val characterOccurrence = charOccurrences[character]
        if (characterOccurrence != null && characterOccurrence == 1) {
            return character
        }
    }
    return string.first()
}