package 백준

import java.util.*

private val dx = intArrayOf(0,1,1)
private val dy = intArrayOf(1,1,0)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n){IntArray(m)}
    val dist = Array(n){IntArray(m){0} }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j]= row[j]
        }
    }
    dist[0][0] = map[0][0]
    val queue : Queue<Maze> = LinkedList()
    queue.offer(Maze(0,0,map[0][0]))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 3){
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny <0 || nx >= n || ny>= m) continue
            if (dist[nx][ny] <= q.cost + map[nx][ny]) {
                dist[nx][ny] = q.cost + map[nx][ny]
                queue.offer(Maze(nx,ny,dist[nx][ny]))
            }
        }
    }
    println(dist[n-1][m-1])
    bw.flush()
}
data class Maze(
        val x : Int,
        val y : Int,
        val cost : Int
)