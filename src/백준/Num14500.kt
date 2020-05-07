package 백준

import kotlin.math.max

private lateinit var map: Array<IntArray>
private val horizontalDx = intArrayOf(-1,-1,0,0,1,1)
private val horizontalDy = intArrayOf(0,1,-1,2,0,1)
private val verticalDx = intArrayOf(-1,0,0,1,1,2)
private val verticalDy = intArrayOf(0,-1,1,-1,1,0)
private var N= 0
private var M = 0
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    N = n[0]
    M = n[1]
    map = Array(n[0]) { IntArray(n[1]) }
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (j + 1 < M-1) {
                horizontalBlockCheck(i,j)
            }
            if (i+1 < N-1) {
                verticalBlockCheck(i,j)
            }
        }
    }
    println(answer)
    bw.flush()
}
private fun verticalBlockCheck(x: Int, y: Int) {
    var block = map[x][y] + map[x+1][y]
    for (i in 0 until 5) {
        val nx = x + verticalDx[i]
        val ny = y + verticalDy[i]
        if (nx < 0 || ny < 0 || nx >= N || ny >= M)continue
        for (j in i+1 until 6) {
            val nnx = x + verticalDx[j]
            val nny = y + verticalDy[j]
            if (nnx < 0 || nny <0 || nnx >= N || nny >= M) continue
            val b = map[nx][ny] + map[nnx][nny]
            answer = if (answer < block +b) block + b else answer
        }
    }
}
private fun horizontalBlockCheck(x: Int ,y : Int) {
    var block = map[x][y] + map[x][y+1]
    for (i in 0 until 5) {
        val nx = x + horizontalDx[i]
        val ny = y + horizontalDy[i]
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
        for (j in i+1 until 6) {
            val nnx = x+ horizontalDx[j]
            val nny = y + horizontalDy[j]
            if (nnx < 0 || nny < 0 || nnx >= N || nny >= M) continue
            val b = map[nx][ny] + map[nnx][nny]
            answer = if (answer < block + b) block + b else answer
        }
    }
}