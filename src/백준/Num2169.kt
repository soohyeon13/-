package 백준

import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var dist : Array<IntArray>
private val dx = intArrayOf(0,1,0)
private val dy = intArrayOf(1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n) { IntArray(m) }
    dist = Array(n) { IntArray(m){0} }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = 100 + row[j]
        }
    }
    bfs()
    bw.flush()
}

private fun bfs() {
    var answer = 0
    val queue : Queue<Mars> = LinkedList()
    queue.offer(Mars(0,0,map[0][0],1))
    dist[0][0] = map[0][0]
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == map.size-1 && q.y == map[0].size-1) {
            val a = q.cost - 100*q.cost
            answer = if (answer < a ) a else answer
        }
        for (i in 0 until 3) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx<0 || ny <0 || nx>=map.size || ny >= map[0].size) continue
            if (dist[nx][ny] < q.cost + map[nx][ny]) {
                dist[nx][ny] = q.cost + map[nx][ny]
                queue.offer(Mars(nx,ny, dist[nx][ny],q.cnt+1))
            }
        }
    }
    println(answer)
}

private data class Mars(
        val x: Int,
        val y: Int,
        val cost: Int,
        val cnt : Int
)
