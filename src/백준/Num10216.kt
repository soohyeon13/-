package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow
import kotlin.math.sqrt

private val towers = ArrayList<Tower>()
private lateinit var visited: BooleanArray
fun main() {
    val input = System.`in`.bufferedReader()
    val T = input.readLine().toInt()
    for (i in 0 until T) {
        val N = input.readLine().toInt()
        for (j in 0 until N) {
            val row = input.readLine().split(" ").map { it.toInt() }
            towers.add(Tower(row[0], row[1], row[2]))
        }
        visited = BooleanArray(towers.size)
        var cnt = 0
        for (j in towers.indices) {
            if (!visited[j]) {
                visited[j] = true
                bfs(j)
                cnt++
            }
        }
        println(cnt)
    }
}

private fun bfs(index: Int) {
    val queue: Queue<Tower> = LinkedList()
    queue.add(towers[index])
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in towers.indices) {
            if (!visited[i] && q.isContinous(towers[i])) {
                visited[i] = true
                queue.add(towers[i])
            }
        }
    }
}

private data class Tower(
        val x: Int,
        val y: Int,
        val r: Int
) {
    fun isContinous(tower: Tower): Boolean {
        return sqrt((this.x - tower.x).toDouble().pow(2.0) + (this.y - tower.y).toDouble().pow(2.0)) <= this.r + tower.r
    }
}