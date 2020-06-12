package 백준

import java.util.*

private val dx = intArrayOf(-2,-2,0,2,2,0)
private val dy = intArrayOf(-1,1,2,1,-1,-2)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val (r1,c1,r2,c2) = br.readLine().split(" ").map{it.toInt()}
    val queue : Queue<DeathKnight> = LinkedList()
    val visited = Array(n){BooleanArray(n)}
    queue.offer(DeathKnight(r1,c1,0))
    visited[r1][c1] = true
    var answer =-1
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == r2 && q.y == c2) {
            answer = q.time
            break
        }
        for (i in dx.indices) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= n || ny>=n) continue
            if (visited[nx][ny]) continue
            queue.offer(DeathKnight(nx,ny,q.time+1))
            visited[nx][ny] = true
        }
    }

    println(answer)
    bw.flush()
}

private data class DeathKnight(
        val x : Int,
        val y : Int,
        val time : Int
)