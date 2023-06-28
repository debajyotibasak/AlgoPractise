package strings.easy

import java.util.Stack

/**
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */
fun main() {
    println(minimumParenthesis(")))()"))
}

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
private fun minimumParenthesisStack(s: String): Int {
    val parenthesisStack = Stack<Char>()
    for (character in s) {
        if (parenthesisStack.isEmpty() || parenthesisStack.peek() == ')') {
            parenthesisStack.push(character)
        } else if (character == ')') {
            parenthesisStack.pop()
        } else if (character == '(') {
            parenthesisStack.push(character)
        }
    }
    return parenthesisStack.size
}

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
private fun minimumParenthesis(s: String): Int {
    var left = 0 // '('
    var right = 0 // ')'
    for (c in s) {
        if (c == '(') {
            left++
        } else {
            if (left > 0) left--
            else right++
        }
    }
    return left + right
}