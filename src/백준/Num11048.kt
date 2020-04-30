package 백준

import java.util.*

private val dx = intArrayOf(0,1,1)
private val dy = intArrayOf(1,1,0)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[0]){IntArray(n[1])}
    val queue : Queue<Maze> = LinkedList()
    for (i in arr.indices) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    queue.add(Maze(0,0,arr[0][0]))
    var answer = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == n[0]-1 && q.y == n[1]-1) {
            answer = if (answer < q.count) q.count else answer
        }
        for (i in 0 until 3) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >=n[0] || ny >= n[1] ) continue
            queue.add(Maze(nx,ny,q.count+arr[nx][ny]))
        }
    }
    println(answer)
    bw.flush()
}
data class Maze(
        val x : Int,
        val y : Int,
        val count : Int
)