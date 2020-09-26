package 백준

import java.util.*

private lateinit var percolateMap: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
fun main() {
    val input = System.`in`.bufferedReader()
    val (M, N) = input.readLine().split(" ").map { it.toInt() }
    percolateMap = Array(M) { IntArray(N) }
    for (i in 0 until M) {
        val row = input.readLine().toCharArray().map { it.toString().toInt() }
        percolateMap[i] = row.toIntArray()
    }
    var answer = false
    for (i in 0 until N) {
        if (isCheckPercolate(0, i,M,N)) {
            answer = true
            break
        }
    }
    if (answer) println("YES")
    else println("NO")
}

private fun isCheckPercolate(x: Int, y: Int, m: Int, n: Int): Boolean {
    val queue: Queue<Point> = LinkedList()
    val visited = Array(m) { BooleanArray(n) }
    queue.add(Point(x, y))
    visited[x][y] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue
            if (percolateMap[nx][ny] == 1) continue
            if (visited[nx][ny]) continue
            if (nx == m - 1) return true
            visited[nx][ny] = true
            queue.add(Point(nx, ny))
        }
    }
    return false
}

private data class Point(
        val x: Int,
        val y: Int
)