package 백준

import kotlin.math.round

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val r = br.readLine().toFloat()
    println(round(r*r*3.14159265358979323846))
    println(2*r*r)
}