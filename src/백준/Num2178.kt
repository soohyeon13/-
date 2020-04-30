package 백준

import java.util.*

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[0]) { IntArray(n[1])}
    val visited = Array(n[0]){BooleanArray(n[1])}
    val queue : Queue<Mazzz> = LinkedList()
    var answer = 0
    for (i in 0 until n[0]) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    queue.add(Mazzz(0,0,1))
    visited[0][0] =true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == n[0]-1 && q.y == n[1]-1) {
            answer = q.move
            break
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx <0 || ny < 0 || nx >= n[0] || ny >= n[1]) continue
            if (!visited[nx][ny]) {
                if (arr[nx][ny] == 1) {
                    queue.add(Mazzz(nx,ny,q.move+1))
                    visited[nx][ny] = true
                }
            }
        }
    }
    println(answer)
    bw.flush()
}

data class Mazzz(
        val x : Int,
        val y : Int,
        val move : Int
)