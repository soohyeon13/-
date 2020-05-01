package 백준

import java.util.*
import kotlin.collections.ArrayList

private val visit = Array(100) { BooleanArray(100) }
private val arr = ArrayList<Dragon>()
private var start = IntArray(2)
private var k = 0
private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)
private var xMax = 0
private var yMax = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        arr.clear()
        val row = br.readLine().split(" ").map { it.toInt() }
        val x = row[0]
        val y = row[1]
        start[0] = y
        start[1] = x
        val dir = row[2]
        val nx = y + dx[dir]
        val ny = x + dy[dir]
        k = row[3]
        arr.add(Dragon(y, x))
        arr.add(Dragon(nx, ny))
        visit[y][x] = true
        visit[nx][ny] = true
        dfs(0, nx, ny)
    }
    var answer = 0
    if(xMax == 0) xMax =100
    if (yMax == 0) yMax = 100
    for (i in 0 until xMax) {
        for (j in 0 until yMax) {
            if (visit[i][j] && visit[i][j+1] && visit[i+1][j] && visit[i+1][j+1]) answer +=1
        }
    }
    println(answer)
    bw.flush()
}

private fun dfs(depth: Int, a: Int, b: Int) {
    if (depth == k) {
        return
    }
    val size = arr.size
    val x = a * -1
    val y = b * -1
    for (i in 0 until size) {
        val c = ((arr[i].x + x) * (-1)) + b
        val d = arr[i].y + y + a
        if (d != a || c != b) {
            if (d > xMax) xMax = d
            if (c > yMax) yMax =c
            visit[d][c] = true
            arr.add(Dragon(d, c))
        }
    }
    start[0] = arr[0].y + y + a
    start[1] = ((arr[0].x + x) * (-1)) + b
    dfs(depth + 1, start[0], start[1])
}

data class Dragon(
        val x: Int,
        val y: Int
)