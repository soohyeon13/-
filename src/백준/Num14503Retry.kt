package 백준

import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n[0]) { IntArray(n[1]) }
    visited = Array(n[0]) { BooleanArray(n[1]) }
    val robot = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    search(robot[0], robot[1], robot[2])
    check()
    println(answer)
    bw.flush()
}

private fun search(x: Int, y: Int, dir: Int) {
    val queue: Queue<RobotClean> = LinkedList()
    arr[x][y] = 9
    queue.add(RobotClean(x, y, dir))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val cx = q.x
        val cy = q.y
        var cd = q.direction
        var nx: Int
        var ny :Int
        var nd :Int
        var flag = false
        for (i in 0 until 4) {
            cd = (cd + 3) % 4
            nx = cx + dx[cd]
            ny = cy + dy[cd]
            val nxBot = RobotClean(nx, ny, cd)
            if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
            if (arr[nx][ny] == 0) {
                queue.add(nxBot)
                arr[nx][ny] = 9
                flag = true
                break
            }
        }
        if (!flag) {
            nd = (cd + 2) % 4
            nx = cx + dx[nd]
            ny = cy + dy[nd]

            if (arr[nx][ny] != 1) {
                arr[nx][ny] = 9
                queue.add(RobotClean(nx, ny, cd))
            }
        }
    }
}
private fun check() {
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 9) {
                answer++
            }
        }
    }
}


data class RobotClean(
        val x: Int,
        val y: Int,
        val direction: Int
)
