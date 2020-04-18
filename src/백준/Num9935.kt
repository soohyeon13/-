package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word = br.readLine()
    val wordArr = word.toCharArray()
    val explosionWord = br.readLine()
    val stack = Stack<Char>()
    for (i in wordArr.size-1 downTo 0) {
        var isCheck = false
        stack.push(wordArr[i])
        if (wordArr[i] == explosionWord[0] && stack.size >= explosionWord.length) {
            isCheck = true
            for (j in 0 until explosionWord.length) {
                if (explosionWord[j] != stack[stack.size-1-j]) {
                    isCheck = false
                    break
                }
            }
            if (isCheck) {
                for (k in 0 until explosionWord.length) {
                    stack.pop()
                }
            }
        }
    }
    val answer = StringBuilder()
    if (stack.isEmpty()) println("FRULA")
    else {
        for (i in 0 until stack.size) {
            answer.append(stack.pop())
        }
        println(answer.toString())
    }
    bw.flush()
}