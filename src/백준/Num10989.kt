package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    for (i in 0 until n) {
        arr.add(br.readLine().toInt())
    }
    val sb = StringBuffer()
    arr.sorted().forEach { sb.append("$it \n") }
    println(sb.toString())
    bw.flush()
}