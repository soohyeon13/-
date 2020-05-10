package 카카오인턴2020

import java.util.*

class AAAA {
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    fun solution(board: Array<IntArray>): Int {
        val queue: Queue<Road> = LinkedList()
        queue.add(Road(0, 1, 0, 1,1))
        queue.add(Road(1, 0, 0, 1,2))
        val dist = Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } }
        dist[0][0] = 0
        dist[0][1] = 100
        dist[1][0] = 100
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.x == board.size-1 && q.y == board.size-1) {
                println("cur :${q.cur} line : ${q.line}")
            }
            for (i in 0 until 4) {
                var cur = 0
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= board.size || ny >= board.size) continue
                if (board[nx][ny] == 1) continue
                if (i == (q.dir +1)%4 || i == (q.dir-1) %4 ) cur = 1
                val cost = (q.cur *500) + (q.line *100) + (cur*500)
                if (dist[nx][ny] >= cost+ 100) {
                    dist[nx][ny] = cost + 100
                    queue.offer(Road(nx, ny, q.cur +cur,q.line+1, i))
                }
            }
        }
        dist.forEach { println(it.contentToString()) }
        return dist[board.size - 1][board.size - 1]
    }

    private data class Road(
            val x: Int,
            val y: Int,
            val cur: Int,
            val line: Int,
            val dir : Int
    )
}