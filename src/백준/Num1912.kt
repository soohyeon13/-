package 백준

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val DP = Array(n){0}
    DP[0] = arr[0]
    var answer = arr[0]
    for (i in 1 until arr.size) {
        DP[i] = max(DP[i-1] + arr[i],arr[i])
        answer = max(DP[i],answer)
    }
    println(answer)
    bw.flush()
}