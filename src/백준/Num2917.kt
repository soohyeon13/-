package 백준

import java.util.*
import kotlin.math.min

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var forestMap: Array<Array<String>>
private val wolfPosition = IntArray(2)
private val housePosition = IntArray(2)
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    forestMap = Array(N) { Array(M) { "" } }
    val treeQueue: Queue<TreePosition> = LinkedList()
    val dist = Array(N) { IntArray(M) { -1 } }
    val priorityTreeQueue = PriorityQueue<PriorityTree>(Comparator<PriorityTree> { t1, t2 ->
        if (t1.minDistance > t2.minDistance) -1
        else 1
    })
    for (i in 0 until N) {
        val row = input.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            forestMap[i][j] = row[j]
            when (row[j]) {
                "+" -> {
                    dist[i][j] = 0
                    treeQueue.add(TreePosition(i, j))
                }
                "V" -> {
                    wolfPosition[0] = i
                    wolfPosition[1] = j
                }
                "J" -> {
                    housePosition[0] = i
                    housePosition[1] = j
                }
                else -> {
                }
            }
        }
    }
    var result = 0
    while (!treeQueue.isEmpty()) {
        val q = treeQueue.poll()
        val treeX = q.x
        val treeY = q.y
        for (i in 0 until 4) {
            val nTreeX = q.x + dx[i]
            val nTreeY = q.y + dy[i]
            if (nTreeX < 0 || nTreeY < 0 || nTreeX >= N || nTreeY >= M) continue
            if (dist[nTreeX][nTreeY] == -1) {
                dist[nTreeX][nTreeY] = dist[treeX][treeY] + 1
                treeQueue.add(TreePosition(nTreeX, nTreeY))
            }
        }
    }
    val startX = wolfPosition[0]
    val startY = wolfPosition[1]
    priorityTreeQueue.add(PriorityTree(startX, startY, dist[startX][startY], dist[startX][startY]))
    while (!priorityTreeQueue.isEmpty()) {
        val q = priorityTreeQueue.poll()
        val curX = q.x
        val curY = q.y
        val distance = q.distance
        val minDistance = q.minDistance
        if (curX == housePosition[0] && curY == housePosition[1]) {
            result = minDistance
            break
        }
        if (dist[curX][curY] == -1) continue
        dist[curX][curY] = -1
        for (i in 0 until 4) {
            val nx = curX + dx[i]
            val ny = curY + dy[i]
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
            if (dist[nx][ny] != -1) {
                priorityTreeQueue.add(PriorityTree(nx, ny, dist[nx][ny], min(dist[nx][ny], minDistance)))
            }
        }
    }
    println(result)
}

private data class PriorityTree(
        val x: Int,
        val y: Int,
        val distance: Int,
        val minDistance: Int
)

private data class TreePosition(
        val x: Int,
        val y: Int
)