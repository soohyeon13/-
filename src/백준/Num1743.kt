package 백준

import java.util.*

private lateinit var garbageMap: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M, K) = input.readLine().split(" ").map { it.toInt() }
    garbageMap = Array(N) { IntArray(M) }
    visited = Array(N) { BooleanArray(M) }
    for (i in 0 until K) {
        val row = input.readLine().split(" ").map { it.toInt() }
        garbageMap[row[0] - 1][row[1] - 1] = 1
    }
    var answer = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (garbageMap[i][j] == 1 && !visited[i][j]) {
                val size = bfs(i, j, N, M)
                if (size > answer) answer = size
            }
        }
    }
    println(answer)
}

private fun bfs(x: Int, y: Int, n: Int, m: Int): Int {
    val queue: Queue<Garbage> = LinkedList()
    var cnt = 1
    queue.add(Garbage(x, y))
    visited[x][y] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if (garbageMap[nx][ny] == 0) continue
            if (visited[nx][ny]) continue
            cnt++
            visited[nx][ny] = true
            queue.add(Garbage(nx,ny))
        }
    }
    return cnt
}

private data class Garbage(
        val x: Int,
        val y: Int
)



















