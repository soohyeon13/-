package 백준

import java.util.*

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var n = 0
private lateinit var visited : Array<BooleanArray>
private lateinit var map : Array<Array<String>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    n = br.readLine().toInt()
    map = Array(n){Array(n){""} }
    visited = Array(n){ BooleanArray(n) }
    for (i in 0 until n ) {
        val row = br.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    val answer = bfs()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if(map[i][j] == "R"){
                map[i][j] = "G"
            }
        }
    }
    visited = Array(n){ BooleanArray(n) }
    val answer2 = bfs()
    println("$answer $answer2")
    bw.flush()
}

private fun bfs() : Int {
    val queue : Queue<Color> = LinkedList()
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                visited[i][j] = true
                queue.offer(Color(i,j, map[i][j]))
                while (!queue.isEmpty()) {
                    val q = queue.poll()
                    for (k in 0 until 4) {
                        val nx = q.x + dx[k]
                        val ny = q.y + dy[k]
                        if (nx < 0 || ny < 0 || nx >= n || ny>= n) continue
                        if (visited[nx][ny]) continue
                        if (q.color == map[nx][ny]) {
                            queue.offer(Color(nx,ny,q.color))
                            visited[nx][ny] = true
                        }
                    }
                }
                count +=1
            }
        }
    }
    return count
}
private data class Color(
         val x : Int,
         val y : Int,
         val color: String
)