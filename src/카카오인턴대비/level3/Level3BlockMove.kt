package 카카오인턴대비.level3

import java.util.*

class Level3BlockMove {
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private lateinit var visited: Array<BooleanArray>
    private val queue: Queue<Robot> = LinkedList()
    private var answer = 0
    fun solution(board: Array<IntArray>): Int {
        visited = Array(board.size) { BooleanArray(board[0].size) }
        bfs(board)
        return answer
    }

    private fun bfs(board: Array<IntArray>) {
        val N = board.size
        visited[0][0] = true
        visited[0][1] = true
        queue.add(Robot(listOf(0, 0), listOf(0, 1), 0))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.front == listOf(N - 1, N - 1) || q.end == listOf(N - 1, N - 1)) {
                answer = q.time
                break
            }
            for (i in 0 until 4) {
                val nxFront = dx[i] + q.front[0]
                val nyFront = dy[i] + q.front[1]
                val nxEnd = dx[i] + q.end[0]
                val nyEnd = dy[i] + q.end[1]
                if (nxFront < 0 || nyFront < 0 || nxEnd < 0 || nyEnd < 0 ||
                        nxFront >= N || nyFront >= N || nxEnd >= N || nyEnd >= N) {
                    continue
                }
                if (board[nxFront][nyFront] == 1 || board[nxEnd][nyEnd] == 1) {
                    continue
                }
                if (!visited[nxFront][nyFront] || !visited[nxEnd][nyEnd]) {
                    val front = listOf<Int>(nxFront, nyFront)
                    val end = listOf<Int>(nxEnd, nyEnd)
                    queue.add(Robot(front, end, q.time + 1))
                    visited[nxFront][nyFront] = true
                    visited[nxEnd][nyEnd] = true
                }
            }
            if (q.front[0] == q.end[0]) {
                horizontalRotate(q.front, q.end, board, q.time)
            } else if (q.front[1] == q.end[1]) {
                verticalRotate(q.front, q.end, board, q.time)
            }
        }
    }

    private fun horizontalRotate(front: List<Int>, end: List<Int>, board: Array<IntArray>, time: Int) {
        if (front[0] - 1 >= 0 && end[0] - 1 >= 0) {
            if (board[front[0] - 1][front[1] + 1] != 1 && board[end[0] - 1][end[1] - 1] == 0) {
                if (!visited[end[0] - 1][end[1] - 1] || !visited[front[0]][front[1]]) {
                    queue.add(Robot(listOf(end[0] - 1, end[1] - 1), front, time + 1))
                }
            }
            if (board[end[0] - 1][end[1] - 1] != 1 && board[front[0] - 1][front[1] + 1] == 0) {
                if (!visited[front[0] - 1][front[1] + 1] || !visited[end[0]][end[1]]) {
                    queue.add(Robot(listOf(front[0] - 1, front[1] + 1), end, time + 1))
                }
            }
        }
        if (front[0] + 1 < board.size && end[0] + 1 < board.size) {
            if (board[front[0] + 1][front[1] + 1] != 1 && board[end[0] + 1][end[1] - 1] == 0) {
                if (!visited[front[0]][front[1]] || !visited[end[0] + 1][end[1] - 1]) {
                    queue.add(Robot(front, listOf(end[0] + 1, end[1] - 1), time + 1))
                }
            }
            if (board[end[0] + 1][end[1] - 1] != 1 && board[front[0] + 1][front[1] + 1] == 0) {
                if (!visited[end[0]][end[1]] || !visited[front[0] + 1][front[1] + 1]) {
                    queue.add(Robot(end, listOf(front[0] + 1, front[1] + 1), time + 1))
                }
            }
        }
    }

    private fun verticalRotate(front: List<Int>, end: List<Int>, board: Array<IntArray>, time: Int) {
        if (front[1] - 1 >= 0 && end[1] - 1 >= 0) {
            if (board[front[0] + 1][front[1] - 1] != 1 && board[end[0] - 1][end[1] - 1] == 0) {
                if (!visited[end[0] - 1][ end[1] - 1] || !visited[front[0]][front[1]])
                    queue.add(Robot(listOf(end[0] - 1, end[1] - 1), front, time + 1))
            }
            if (board[end[0] - 1][end[1] - 1] != 1 && board[front[0] + 1][front[1] - 1] == 0) {
                if (!visited[front[0] + 1][front[1] - 1] || !visited[end[0]][end[1]]) {
                    queue.add(Robot(listOf(front[0] + 1, front[1] - 1), end, time + 1))
                }
            }
        }
        if (front[1] + 1 < board.size && end[1] + 1 <= board.size) {
            if (board[end[0] - 1][end[1] + 1] != 1 && board[front[0] + 1][front[1] + 1] == 0) {
                if (!visited[end[0]][end[1]] || !visited[front[0] + 1][front[1] + 1])
                queue.add(Robot(end, listOf(front[0] + 1, front[1] + 1), time + 1))
            }
            if (board[front[0] + 1][front[1] + 1] != 1 && board[end[0] - 1][end[1] + 1] == 0) {
                if (!visited[front[0]][front[1]] || !visited[end[0] - 1][end[1] + 1])
                queue.add(Robot(front, listOf(end[0] - 1, end[1] + 1), time + 1))
            }
        }
    }

    data class Robot(
            val front: List<Int>,
            val end: List<Int>,
            var time: Int
    )
}

fun main() {
    val sol = Level3BlockMove()
    val board = arrayOf(
            intArrayOf(0, 0, 0, 1, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 1),
            intArrayOf(1, 1, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0)
    )
    println(sol.solution(board))
}