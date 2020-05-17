package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n =  br.readLine().toInt()
    val map = Array(n){IntArray(n)}
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    val queue :Queue<Jump> = LinkedList()
    queue.offer(Jump(0,0))
    var answer = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == n-1 && q.y == n-1) {
            answer +=1
            continue
        }
        val nx = q.x + map[q.x][q.y]
        val ny = q.y + map[q.x][q.y]
        if (nx < n) {
            queue.offer(Jump(nx,q.y))
        }
        if (ny < n) {
            queue.offer(Jump(q.x,ny))
        }
    }
    println(answer)
    bw.flush()
}
private data class Jump(
        val x : Int,
        val y : Int
)