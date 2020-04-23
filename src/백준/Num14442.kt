package 백준

import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visit: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var answer = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val N = n[0]
    val M = n[1]
    val K = n[2]
    arr = Array(N) { IntArray(M) }
    visit = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        for (j in 0 until M) {
            arr[i][j] = row[j]
            visit[i][j] = Int.MAX_VALUE
        }
    }
    bfs(0, 0, N, M, K)
    if (answer == Int.MAX_VALUE) println(-1)
    else println(answer)
}

private fun bfs(x: Int, y: Int, n: Int, m: Int, k: Int) {
    val queue: Queue<Go> = LinkedList()
    queue.add(Go(x, y, 1, 0))
    visit[x][y] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == n - 1 && q.y == m - 1) {
            answer = q.count
            break
        }
        if (q.x < 0 || q.y < 0 || q.x >= n || q.y >= m) continue
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx <0 || ny <0 || nx >=n || ny>= m) continue
            if (visit[nx][ny] <= q.destory) continue
            if (arr[nx][ny] == 0) {
                visit[nx][ny] = q.destory
                queue.add(Go(nx,ny,q.count+1,q.destory))
            }else {
                if(q.destory < k) {
                    visit[nx][ny] = q.destory+1
                    queue.add(Go(nx,ny,q.count+1,q.destory+1))
                }
            }
        }
    }
}

data class Go(
        var x: Int,
        var y: Int,
        var count: Int,
        var destory: Int
)