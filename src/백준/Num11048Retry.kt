package 백준

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n+1){IntArray(m+1)}
    for (i in 1 .. n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..m) {
            map[i][j] = row[j-1]
        }
    }

    for (i in 1..n) {
        for (j in 1..m) {
            map[i][j] += max(map[i][j-1], max(map[i-1][j],map[i-1][j-1]))
        }
    }
    println(map[n][m])
    bw.flush()
}