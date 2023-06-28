package strings.easy

/**
 * Write a function that takes in a non-empty string and returns its run-length encoding. From
 * Wikipedia, "run-length encoding is a form of lossless data compression in which runs of data are
 * stored as a single data value and count, rather than as the original run." For this problem, a
 * run of data is any sequence of consecutive, identical characters. So the run "AAA" would be
 * run-length-encoded as "3A"
 *
 * To make things more complicated, however, the input string can contain all sorts of special
 * characters, including numbers. And since encoded data must be decodable, this means that we can't
 * naively run-length-encode long runs. For example, the run "AAAAAAAAAAAA" (12 A s), can't naively
 * be encoded as "12A", since this string can be decoded as either "AAAAAAAAAAAA" or 1AA" . Thus,
 * long runs (runs of 10 or more characters) should be encoded in a split fashion; the
 * aforementioned run should be encoded as "9A3A"
 *
 * Sample Input
 * string = "AAAAAAAAAAAAABBCCCCDD"
 * Sample Output
 * "9A4A2B4C2D"
 */
fun main() {
    println(runLengthEncodedString("CAAAAAAAAAAAAABBCCCCDD"))
}

/**
 * O(n) Time
 * O(n) Space
 */
private fun runLengthEncodedString(input: String): String {
    val encodedStringList = mutableListOf<String>()
    var currentRunLength = 1
    for (index in 1 until input.length) {
        val currentCharacter = input[index]
        val previousCharacter = input[index - 1]
        if (currentCharacter != previousCharacter || currentRunLength == 9) {
            encodedStringList.add("$currentRunLength$previousCharacter")
            currentRunLength = 0
        }
        currentRunLength++
    }
    encodedStringList.add("$currentRunLength${input[input.length - 1]}")
    return encodedStringList.joinToString("")
}