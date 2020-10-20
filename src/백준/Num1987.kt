package 백준

import kotlin.math.max

private lateinit var arr: Array<Array<Char>>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var r = 0
private var c = 0
private var maxCount = Int.MIN_VALUE
fun main() {
    val input = System.`in`.bufferedReader()
    val (R, C) = input.readLine().split(" ").map { it.toInt() }
    r = R
    c = C
    arr = Array(R) { Array(C) { ' ' } }
    for (i in 0 until R) {
        val row = input.readLine().toCharArray()
        arr[i] = row.toTypedArray()
    }
    val visited = BooleanArray(26)
    visited[arr[0][0].toInt() - 65] = true
    dfs(0, 0, visited, 1)
    println(maxCount)
}

private fun dfs(x: Int, y: Int, visited: BooleanArray, cnt: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue
        if (visited[arr[nx][ny].toInt() - 65]) {
            maxCount = max(maxCount,cnt)
            continue
        }
        visited[arr[nx][ny].toInt() - 65] = true
        dfs(nx, ny, visited, cnt + 1)
        visited[arr[nx][ny].toInt() - 65] = false
    }
}