package 카카오인턴2020

import java.util.*

class Solution4 {
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    fun solution(board: Array<IntArray>): Int {
        val queue: Queue<Road> = LinkedList()
        queue.add(Road(0, 0, 0, 1))
        queue.add(Road(0, 0, 0, 2))
        val dist = Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } }
        dist[0][0] = 0
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (i in 0 until 4) {
                var cur = 0
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= board.size || ny >= board.size) continue
                if (board[nx][ny] == 1) continue
                if (i == (q.dir + 1)%4 || i == (q.dir-1) %4 ) cur = 500
                if (q.dir-1 == -1 && i == 3) cur = 500
                if (dist[nx][ny] >= q.cost + cur + 100) {
                    dist[nx][ny] = q.cost + cur + 100
                    queue.offer(Road(nx, ny, q.cost + 100 + cur, i))
                }
            }
        }
        return dist[board.size - 1][board.size - 1]
    }

    private data class Road(
            val x: Int,
            val y: Int,
            val cost: Int,
            val dir: Int
    )
}