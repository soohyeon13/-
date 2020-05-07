package 백준

import java.lang.StringBuilder
import java.util.*

private val calu = intArrayOf(-1, 1)
private val visited = BooleanArray(100001) { false }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val N = n[0]
    val K = n[1]
    bfs(N, K)
    bw.flush()
}

private fun bfs(n: Int, k: Int) {
    val queue: Queue<Play> = LinkedList()
    queue.add(Play(n, 0, n.toString()))
    visited[n] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.num == k) {
            println(q.time)
            println(q.word.trim())
            return
        }
        for (i in calu.indices) {
            val nx = q.num + calu[i]
            if (nx < 0) continue
            if (nx > 100000) continue
            if (!visited[nx]) {
                val sb = StringBuilder()
                sb.append(q.word).append(" ").append(nx)
                queue.add(Play(nx, q.time + 1, sb.toString()))
                visited[nx] = true
            }
        }
        val nx = q.num *2
        if (nx > 100000) continue
        if (!visited[q.num * 2]) {
            val sb = StringBuilder()
            sb.append(q.word).append(" ").append(nx)
            queue.add(Play(q.num * 2, q.time + 1, sb.toString()))
            visited[q.num * 2] = true
        }
    }
}

data class Play(
        val num: Int,
        val time: Int,
        val word: String
)