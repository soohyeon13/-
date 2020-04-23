package 백준

import java.util.*

private lateinit var visited : Array<IntArray>
private lateinit var arr : Array<IntArray>
private val dy = intArrayOf(0,0,-1,1)
private val dx = intArrayOf(-1,1,0,0)
private var answer =Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ")
    arr = Array(n[0].toInt()){ IntArray(n[1].toInt()) }
    visited = Array(n[0].toInt()) { IntArray(n[1].toInt()) }
    for (i in 0 until n[0].toInt()) {
        val row = br.readLine().toCharArray()
        for (j in 0 until n[1].toInt()){
            arr[i][j] = row[j].toString().toInt()
            visited[i][j] = Int.MAX_VALUE
        }
    }
    bfs(0,0,n[0].toInt(),n[1].toInt())
    if (answer == Int.MAX_VALUE) println(-1)
    else println(answer)

}
private fun bfs(y:Int,x:Int,n:Int,m:Int) {
    val queue :Queue<Move> = LinkedList()
    queue.add(Move(y,x,1,0))
    visited[0][0] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.y == n-1 && q.x == m-1) {
            answer = q.count
            break
        }
        for (i in 0 until 4) {
            val ny = q.y + dy[i]
            val nx = q.x  + dx[i]
            if (ny < 0|| nx < 0 || ny >= n || nx >= m) continue
            if (visited[ny][nx] <= q.destory) continue
            if (arr[ny][nx] ==0) {
                visited[ny][nx] = q.destory
                queue.add(Move(ny,nx,q.count+1,q.destory))
            }else {
                if (q.destory == 0) {
                    queue.add(Move(ny,nx,q.count+1,q.destory+1))
                }
            }
        }
    }
}

data class Move(
        var y : Int,
        var x : Int,
        var count : Int,
        var destory : Int
)