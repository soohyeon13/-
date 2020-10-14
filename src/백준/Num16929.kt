package 백준

import java.util.*

private lateinit var playDotsMap: Array<Array<String>>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var m = 0
private var flag = false
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    playDotsMap = Array(N) { Array(M) { "" } }
    for (i in 0 until N) {
        val row = input.readLine().toCharArray().map { it.toString() }.toTypedArray()
        playDotsMap[i] = row
    }
    loop@ for (i in 0 until n) {
        for (j in 0 until m) {
            val visited = Array(n) { BooleanArray(m) }
            visited[i][j] = true
            val dot = Dots(i, j, playDotsMap[i][j])
            dfs(i, j, visited, dot, 0)
            if (flag) break@loop
        }
    }

    if (flag) println("YES")
    else println("NO")
}

private fun dfs(x: Int, y: Int, visited: Array<BooleanArray>, dot: Dots, cnt: Int) {
    if (cnt > 3 && x == dot.x && y == dot.y && playDotsMap[x][y] == dot.value) {
        flag = true
        return
    }
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
        if (cnt > 3 && nx == dot.x && ny == dot.y && playDotsMap[nx][ny] == dot.value) {
            flag = true
            return
        }
        if (visited[nx][ny]) continue
        if (playDotsMap[nx][ny] != dot.value) continue
        visited[nx][ny] = true
        dfs(nx, ny, visited, dot, cnt + 1)
        visited[nx][ny] = false
    }
}


private data class Dots(
        val x: Int,
        val y: Int,
        val value: String
)