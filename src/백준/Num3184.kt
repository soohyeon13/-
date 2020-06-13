package 백준

import java.util.*

private lateinit var map : Array<Array<String>>
private lateinit var visited : Array<BooleanArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var sheeps = 0
private var wolfs = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r,c) = br.readLine().split(" ").map{it.toInt()}
    map = Array(r){ Array(c){""} }
    visited = Array(r){BooleanArray(c)}
    for (i in 0 until r) {
        val row = br.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] !="#" && !visited[i][j]) {
                bfs(i,j,r,c)
            }
        }
    }
    println("$sheeps $wolfs")
    bw.flush()
}

private fun bfs(x : Int, y : Int,n: Int, m: Int) {
    var sheep = 0
    var wolf = 0
    if (map[x][y] == "o") sheep++
    if (map[x][y] == "v") wolf++
    val queue : Queue<Dot> = LinkedList()
    queue.offer(Dot(x,y))
    visited[x][y] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny <0 || nx>= n || ny >= m) continue
            if (visited[nx][ny]) continue
            if (map[nx][ny] == "#") continue
            if (map[nx][ny] == "o") sheep++
            if (map[nx][ny] == "v") wolf++
            queue.offer(Dot(nx,ny))
            visited[nx][ny] = true
        }
    }
    if (sheep > wolf) {
        sheeps += sheep
    }else {
        wolfs += wolf
    }
}
private data class Dot(
        val x : Int,
        val y : Int
)
