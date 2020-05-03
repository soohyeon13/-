package 백준

import java.util.*

private val dx = intArrayOf(0,1,0)
private val dy = intArrayOf(1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n[0]){ IntArray(n[1]) }
    val dp = Array(n[0]){ IntArray(n[1]) {-1} }
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    dp[0][0] = map[0][0]
}