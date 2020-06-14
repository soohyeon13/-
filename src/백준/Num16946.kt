package 백준

import java.util.*

private lateinit var map : Array<IntArray>
private val zeroSet = IntArray(1000010)
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var index = 1
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map{it.toInt()}
    map = Array(n){ IntArray(m) }
    for (i in 0 until n) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 0) bfs(i,j)
        }
    }
    val sb = StringBuilder()
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 1) {
                sb.append(zeroSum(i,j)+1)
            }else if (map[i][j] >1) {
                sb.append(0)
            }
        }
        sb.append("\n")
    }
    println(sb.toString())
    bw.flush()
}
private fun zeroSum(x : Int , y: Int) : Int {
    var sum =0
    val visited = BooleanArray(1000010)
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx>= map.size || ny >= map[0].size) continue
        if (map[nx][ny] >1) {
            if (!visited[map[nx][ny]]) {
                sum += zeroSet[map[nx][ny]]
                visited[map[nx][ny]] = true
            }
        }
    }
    return sum
}
private fun bfs(x: Int, y : Int) {
    val queue : Queue<Zero> = LinkedList()
    val visited = Array(map.size){BooleanArray(map[0].size)}
    queue.offer(Zero(x,y))
    visited[x][y] = true
    index++
    map[x][y] = index
    var cnt = 1
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx>= map.size || ny >= map[0].size) continue
            if (visited[nx][ny]) continue
            if (map[nx][ny] != 0) continue
            if (map[nx][ny] == 0) cnt++
            map[nx][ny] = index
            queue.offer(Zero(nx,ny))
            visited[nx][ny] = true
        }
    }
    zeroSet[index] = cnt%10
}

private data class Zero(
        val x : Int,
        val y : Int
)