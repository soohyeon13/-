package 백준

import java.util.*
import kotlin.collections.ArrayList

private var N = 0
private var M = 0
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var arr: Array<CharArray>
private val robotList = ArrayList<Robot>()
private lateinit var visited : Array<Boolean>
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    loop@while (true) {
        val n = br.readLine().split(" ").map { it.toInt() }
        N = n[1]
        M = n[0]
        if (N == 0 && M == 0) break
        arr = Array(N){ CharArray(M) }
        for (i in 0 until N) {
            val row = br.readLine().toCharArray()
            for (j in 0 until M) {
                arr[i][j] = row[j]
                if (arr[i][j] == 'o') robotList.add(0, Robot(i,j))
                else if (arr[i][j] == '*') robotList.add(Robot(i,j))
            }
        }
        val d = Array(robotList.size){IntArray(robotList.size)}
        for (i in robotList.indices) {
            val robot = robotList[i]
            val dist = bfs(robot)
            for (j in robotList.indices) {
                val dest = robotList[j]
                d[i][j] = dist[dest.x][dest.y]
                if (d[i][j] == Int.MAX_VALUE) {
                    println(-1)
                    continue@loop
                }
            }
        }
        visited = Array(robotList.size){false}
        answer = Int.MAX_VALUE
        dfs(0,0, robotList.size -1, 0 ,d)
        println(answer)
    }
    bw.flush()
}

private fun dfs(num: Int, sum: Int, end: Int, index : Int, d: Array<IntArray>) {
    if (index == end) {
        if (sum < answer) {
            answer = sum
        }
        return
    }
    for (i in 1 until robotList.size) {
        if (visited[i]) continue
        visited[i] = true
        val next = sum + d[num][i]
        dfs(i,next,end,index+1,d)
        visited[i] =false
    }
}

private fun bfs(robot: Robot): Array<IntArray> {
    val dist = Array(N) {IntArray(M)}
    for (i in 0 until N) {
        for (j in 0 until M) {
            dist[i][j] = Int.MAX_VALUE
        }
    }
    dist[robot.x][robot.y] = 0
    val queue : Queue<Robot> = LinkedList()
    while (!queue.isEmpty()) {
        val q = queue.remove()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >=N || ny >=M) continue
            if (arr[nx][ny] == 'x') continue
            if (dist[nx][ny] <= dist[q.x][q.y] +1) continue
            dist[nx][ny] = dist[q.x][q.y] +1
            queue.add(Robot(nx,ny))
        }
    }
    return dist
}

data class Robot(
        val x: Int,
        val y: Int
)