package 백준

import java.util.*

private var N = 0
private var M = 0
private var K = 0
private lateinit var arr: Array<BooleanArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private val hdx = intArrayOf(-2,-1,1,2,2,1,-1,-2)
private val hdy = intArrayOf(1,2,2,1,-1,-2,-2,-1)
private var answer =-1
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    K = br.readLine().toInt()
    val n = br.readLine().split(" ")
    N = n[1].toInt()
    M = n[0].toInt()
    arr = Array(N) { BooleanArray(M) }
    visited = Array(N) { BooleanArray(M) }
    for (i in 0 until N) {
        val row = br.readLine().split(" ")
        for (j in 0 until M) {
            arr[i][j] = row[j].toInt() == 0
        }
    }
    bfs(0,0)
    println(answer)
    bw.flush()
}

private fun bfs(x:Int,y:Int) {
    val queue : Queue<Monkey> = LinkedList()
    visited[x][y] = true
    queue.add(Monkey(x,y,0,0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == N-1 && q.y == M-1) {
            answer = q.count
            break
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
            if (!arr[nx][ny] || visited[nx][ny]) continue
            queue.add(Monkey(nx,ny,q.count+1,q.hourse))
        }
        if (q.hourse < K) {
            for (i in 0 until 8) {
                val dnx = q.x + hdx[i]
                val dny = q.y + hdy[i]
                if (dnx < 0 || dny < 0 || dnx >= N || dny >= M) continue
                if (!arr[dnx][dny] || visited[dnx][dny]) continue
                queue.add(Monkey(dnx,dny,q.count +1 ,q.hourse+1))
            }
        }
    }
}

data class Monkey(
        val x : Int,
        val y: Int,
        var count : Int,
        var hourse : Int
)


















