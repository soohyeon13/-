package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(100001)
    val queue: Queue<HideGame> = LinkedList()
    queue.offer(HideGame(n, 0))
    visited[n] = true
    var answer = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.num == k) {
            answer = q.time
            break
        }
        if (q.num - 1 >= 0 && !visited[q.num - 1]) {
            queue.offer(HideGame(q.num - 1, q.time + 1))
            visited[q.num - 1] = true
        }
        if (q.num + 1 <= 100000 && !visited[q.num + 1]) {
            queue.offer(HideGame(q.num + 1, q.time + 1))
            visited[q.num + 1] = true
        }
        if (q.num * 2 <= 100000 && !visited[q.num * 2]) {
            queue.offer(HideGame(q.num * 2, q.time + 1))
            visited[q.num * 2] = true
        }
    }
    println(answer)
    bw.flush()
}

private data class HideGame(
        val num: Int,
        val time: Int
)