package 백준

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()
    val DP = Array(n+1){Int.MAX_VALUE}
    DP[1] = arr[0]
    for (i in 2 .. n) {
        for (j in 1 until i) {
            val m = min(DP[i-j] + DP[j],arr[i-1])
            DP[i] = min(DP[i],m)
        }
    }
    println(DP[n])
    bw.flush()
}