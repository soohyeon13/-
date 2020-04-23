package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val keyWord = br.readLine()
    var text = br.readLine()
    var lowIndex = 0
    var highIndex = 0
    var keyIndex = 0
    while (true) {

        // 1.조건
        if (!text.contains(keyWord)) break

        // 2.조건
        highIndex = 0
        lowIndex = 0
        keyIndex = 0
        for (i in 0 until text.length) {
            if (keyWord[keyIndex] == text[highIndex]) {
                keyIndex++
                highIndex++
            } else {
                highIndex++
                lowIndex = highIndex
                keyIndex = 0
            }
            if ((highIndex - lowIndex) == keyWord.length - 1) {
                text = text.removeRange(lowIndex..highIndex)
                break
            }
        }
        println(text)
        // 3.조건
        if (!text.contains(keyWord)) break

        // 4.조건
        keyIndex = keyWord.length - 1
        highIndex = text.length - 1
        lowIndex = text.length - 1
        for (i in text.length - 1 downTo 0) {
            if (keyWord[keyIndex] == text[highIndex]) {
                keyIndex--
                highIndex--
            }else {
                highIndex--
                lowIndex = highIndex
                keyIndex = keyWord.length-1
            }
            if ((lowIndex-highIndex) == keyWord.length-1) {
                text = text.removeRange(highIndex..lowIndex)
                break
            }
        }
    }
    println(text)
    bw.flush()
}