package 카카오인턴2020

import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var roadMap: Array<IntArray>
class RetrySolution4 {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        val queue: Queue<Road> = LinkedList()
        queue.offer(Road(0, 0, 1, 0))
        queue.offer(Road(0, 0, 2, 0))
        roadMap = Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } }
        roadMap[0][0] = 0
        while (!queue.isEmpty()) {
            val road = queue.poll()
            for (nDir in 0 until 4) {
                var addCost = 100
                val nx = road.x + dx[nDir]
                val ny = road.y + dy[nDir]
                if (nx < 0 || ny < 0 || nx >= board.size || ny >= board.size) continue
                if (board[nx][ny] == 1) continue
                if ((road.dir - 1) % 4 == nDir || (road.dir + 1) % 4 == nDir) addCost += 500
                if (nDir == 3 && road.dir - 1 == -1) addCost += 500
                if (roadMap[nx][ny] >= road.cost + addCost) {
                    roadMap[nx][ny] = road.cost + addCost
                    queue.offer(Road(nx, ny, nDir, road.cost + addCost))
                }
            }
        }
        answer = roadMap[board.size-1][board.size-1]
        return answer
    }
}

private data class Road(
        val x: Int,
        val y: Int,
        val dir: Int,
        val cost: Int
)