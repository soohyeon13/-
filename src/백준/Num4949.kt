package 백준

import java.util.*

private lateinit var stack : Stack<Char>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var word = ""
    while (true) {
        val s = br.readLine()
        if (s == ".") break
        word += s
    }
    val arr = word.split(".")
    loop@for (i in 0 until arr.size-1) {
        val wordArr = arr[i].toCharArray()
        stack = Stack()
        for (j in wordArr.indices) {
            when(wordArr[j]) {
                '(' -> stack.push(wordArr[j])
                ')' -> {
                    if(!isSmallCheck(wordArr[j])) {
                        continue@loop
                    }
                }
                '[' -> stack.push(wordArr[j])
                ']' -> {
                    if (!isBigCheck(wordArr[j])) {
                        continue@loop
                    }
                }
            }
        }
        if (stack.isEmpty()) println("yes")
        else println("no")
    }
    bw.flush()
}

private fun isSmallCheck(w : Char) : Boolean {
    if (isEmptyCheck()) {
        printNo()
        return false
    }
    if (stack.peek() == '('){
        stack.pop()
        return true
    }else {
        printNo()
        return false
    }
}

private fun isBigCheck(w : Char) : Boolean {
    if (isEmptyCheck()) {
        printNo()
        return false
    }
    if (stack.peek() == '['){
        stack.pop()
        return true
    }else {
        printNo()
        return false
    }
}

private fun isEmptyCheck() : Boolean = stack.isEmpty()
private fun printNo() = println("no")