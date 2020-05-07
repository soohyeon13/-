package 백준

import kotlin.math.max
import kotlin.math.min

private lateinit var dist: Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val v = n[0]
    val edge = n[1]
    val destination = n[2]
    dist = Array(v + 1) { IntArray(v + 1) { 0 } }
    for (i in 1..v) {
        for (j in 1..v) {
            if (i != j) dist[i][j] = 1000001
        }
    }
    for (i in 0 until edge) {
        val row = br.readLine().split(" ").map { it.toInt() }
        dist[row[0]][row[1]] = min(dist[row[0]][row[1]], row[2])
    }
    for (k in 1..v) {
        for (i in 1..v) {
            for (j in 1..v) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }
    var result = 0
    for (i in 1..v) {
        result = max(result, dist[i][destination] + dist[destination][i])
    }
    println(result)
    bw.flush()
}