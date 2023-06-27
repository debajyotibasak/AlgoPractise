package strings.medium

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
fun main() {
    println(reverseStringWordWise(" Hey this is  Deba! "))
    println(reverseStringWordWise("Hey this   is Tinu!"))
}

private fun reverseStringWordWise(sentence: String): String {
    val wordList = mutableListOf<String>()
    var startIndex = 0
    for (index in sentence.indices) {
        if (sentence[index] == ' ') {
            val substring = sentence.substring(
                startIndex = startIndex,
                endIndex = index
            )
            if (substring.isNotBlank()) wordList.add(substring)
            startIndex = index
        } else if (sentence[startIndex] == ' ') {
            startIndex = index
        }
    }
    wordList.add(sentence.substring(startIndex))
    return wordList.reverseString().joinToString(" ").trim()
}

private fun MutableList<String>.reverseString(): MutableList<String> {
    var startIndex = 0
    var endIndex = this.size - 1
    while (startIndex < endIndex) {
        val temp = this[startIndex]
        this[startIndex] = this[endIndex]
        this[endIndex] = temp
        startIndex++
        endIndex--
    }
    return this
}

// Short solution
fun reverseWords(s: String): String {
    return s.trim()
        .split("\\s+".toRegex())
        .reversed()
        .joinToString(" ")
}