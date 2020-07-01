package 백준

import java.util.*

private lateinit var stack: Stack<Char>
fun main() {
    val br = System.`in`.bufferedReader()
    loop@while (true) {
        val s = br.readLine().toCharArray()
        if (s[0] =='.') break
        stack = Stack<Char>()
        for (i in s.indices) {
            when(s[i]) {
                '(' -> stack.push(s[i])
                ')' -> {
                    if (isCheckRight('(')) stack.pop()
                    else continue@loop
                }
                '[' -> stack.push(s[i])
                ']' -> {
                    if (isCheckRight('[')) stack.pop()
                    else continue@loop
                }
            }
        }
        if (stack.isEmpty()) println("yes")
    }
}
private fun isCheckRight(word : Char) : Boolean {
    if (!stack.isEmpty() && stack.peek() == word) return true
    println("no")
    return false
}