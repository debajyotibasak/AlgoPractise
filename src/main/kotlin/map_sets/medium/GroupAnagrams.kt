package map_sets.medium

/**
 * You have been given an array/list of strings 'inputStr'. You are supposed to return the strings as groups of anagrams
 * such that strings belonging to a particular group are anagrams of one another.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. We can generalize
 * this in string processing by saying that an anagram of a string is another string with the same quantity of each
 * character in it, in any order.
 *
 * For Example:
 * inputStr = {"eat", "tea", "tan", "ate", "nat", "bat" }
 * Here {"tea", "ate"," eat"} and {"nat", "tan"} are grouped as anagrams. Since there is no such string in
 * "inputStr" which can be an anagram of "bat", thus, "bat" will be the only member in its group.
 */
fun main() {
    print(groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat")))
}

/**
 * Time complexity : O(w*n*log n)
 * Space complexity : O(w*n)
 * w -> no of words
 * n -> the largest length of strings
 * log n -> for sorting the strings
 */
fun groupAnagrams(strArray: List<String>): List<List<String>> {
    val sortedAnagram = mutableMapOf<String, MutableList<String>>()
    for (str in strArray) {
        val sortedString = str.toCharArray().sorted().joinToString("")
        if (sortedAnagram.containsKey(sortedString)) {
            sortedAnagram[sortedString]?.add(str)
        } else {
            sortedAnagram[sortedString] = mutableListOf(str)
        }
    }
    return sortedAnagram.values.toList()
}