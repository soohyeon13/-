package 백준

import java.util.*

private lateinit var chessMap: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var answer = 0
private var n = 0
private var m = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    chessMap = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        chessMap[i] = row.toIntArray()
    }
    while (true) {
        var flag = true
        for (i in chessMap.indices) {
            for (j in chessMap[i].indices) {
                if (chessMap[i][j] == 1) flag = false
            }
        }
        if (flag) break
        bfs()
    }
    println(answer)
}

private fun bfs() {
    val countMap = Array(n) { IntArray(m) }
    val queue: Queue<Air> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }
    queue.add(Air(0, 0))
    visited[0][0] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if (visited[nx][ny]) continue
            if (chessMap[nx][ny] == 1) {
                countMap[nx][ny] += 1
                continue
            }
            visited[nx][ny] = true
            queue.add(Air(nx, ny))
        }
    }
    for (i in countMap.indices) {
        for (j in countMap[i].indices) {
            if (countMap[i][j] >= 2) chessMap[i][j] = 0
        }
    }
    answer += 1
}

private data class Air(
        val x: Int,
        val y: Int
)