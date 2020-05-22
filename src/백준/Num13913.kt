package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue: Queue<SecondHideGame> = LinkedList()
    val visited = Array(110021) { false }
    queue.offer(SecondHideGame(n, 0, "$n "))
    visited[n] = true
    var answer =0
    var answerPath = ""
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.num == k) {
            answer = q.time
            answerPath = q.path
            break
        }
        if (q.num - 1 >= 0 && !visited[q.num - 1]) {
            queue.offer(SecondHideGame(q.num - 1, q.time + 1,"${q.path} ${q.num-1}"))
            visited[q.num - 1] = true
        }
        if (q.num + 1 <= 110020 && !visited[q.num + 1]) {
            queue.offer(SecondHideGame(q.num + 1, q.time + 1, "${q.path} ${q.num+1}"))
            visited[q.num + 1] = true
        }
        if (q.num * 2 <= 110020 && !visited[q.num * 2]) {
            queue.offer(SecondHideGame(q.num * 2, q.time + 1, "${q.path} ${q.num*2}"))
            visited[q.num * 2] = true
        }
    }
    println(answer)
    println(answerPath)
    bw.flush()
}

private data class SecondHideGame(
        val num: Int,
        val time: Int,
        val path: String
)