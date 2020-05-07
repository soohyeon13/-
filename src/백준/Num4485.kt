package 백준

import java.util.*

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var cnt = 1
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        val arr = Array(n){IntArray(n)}
        val visited = Array(n){BooleanArray(n)}
        val dist = Array(n){IntArray(n) {13000} }
        for (i in 0 until n) {
            val row = br.readLine().split(" ").map { it.toInt() }
            for (j in row.indices) {
                arr[i][j] = row[j]
            }
        }
        val queue : Queue<Zelda> = LinkedList()
        dist[0][0] = arr[0][0]
        queue.offer(Zelda(0,0,arr[0][0]))
        var answer = Int.MAX_VALUE
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.x == n-1 && q.y == n-1) {
                answer = if (answer > q.cost) q.cost else answer
                continue
            }
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny <0 || nx >= n || ny >= n) continue
                if (dist[nx][ny] > q.cost + arr[nx][ny]) {
                    dist[nx][ny] = q.cost + arr[nx][ny]
                    queue.offer(Zelda(nx,ny,dist[nx][ny]))
                }
            }
        }
        println("Problem ${cnt}: $answer")
        cnt +=1
    }
    bw.flush()
}
private data class Zelda(
        val x : Int,
        val y : Int,
        val cost : Int
)