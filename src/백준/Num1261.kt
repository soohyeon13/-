package 백준

import java.util.*
import kotlin.Comparator

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[1]){IntArray(n[0])}
    val dist = Array(n[1]){IntArray(n[0]){Int.MAX_VALUE}}
    val queue :PriorityQueue<Spot> =
            PriorityQueue(Comparator<Spot> { p0, p1 -> if (p0.wall > p1.wall) 1 else -1 })
    var answer = 0
    for (i in 0 until n[1]) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    queue.add(Spot(0,0,0))
    dist[0][0] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == n[1]-1 && q.y == n[0]-1) {
            answer = q.wall
            break
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= n[1] || ny >= n[0]) continue
            if (dist[nx][ny] > dist[q.x][q.y] + arr[nx][ny]) {
                dist[nx][ny] = dist[q.x][q.y] + arr[nx][ny]
                queue.add(Spot(nx,ny,dist[nx][ny]))
            }
        }
    }
    println(answer)
    bw.flush()
}
data class Spot(
        val x : Int,
        val y : Int,
        var wall : Int
)