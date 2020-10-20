package 백준

import java.util.*

private lateinit var ballMap: Array<Array<String>>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var m = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    ballMap = Array(N) { Array(M) { "" } }
    val redBallMap = IntArray(2)
    val blueBallMap = IntArray(2)
    for (i in 0 until N) {
        val row = input.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            if (row[j] == "B") {
                blueBallMap[0] = i
                blueBallMap[1] = j
            }
            if (row[j] == "R") {
                redBallMap[0] = i
                redBallMap[1] = j
            }
            ballMap[i][j] = row[j]
        }
    }
}

private fun bfs(red: IntArray, blue: IntArray) {
    val queue: Queue<Ball> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }
    queue.add(Ball(red[0],red[1],blue[0],blue[1]))
    while (!queue.isEmpty()) {
        val q= queue.poll()
        for (i in 0 until 4) {
            //TODO 방향 전환
            dfs()
        }
    }
}

private fun dfs() {
    //TODO 그 방향으로 깊이 탐색
}


private data class Ball(
        val redX: Int,
        val redY: Int,
        val blueX: Int,
        val blueY: Int
)