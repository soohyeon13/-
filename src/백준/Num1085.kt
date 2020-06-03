package 백준

import kotlin.math.abs
import kotlin.math.min
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (x,y,w,h) = br.readLine().split(" ").map { it.toInt() }

    val answer = min(min(abs(h-y), abs(y-0)),min(abs(w-x), abs(x-0)))
    println(answer)
    bw.flush()
}