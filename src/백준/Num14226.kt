package 백준

import java.util.*

private var N = 0
private var answer = 0
private var count = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    N = br.readLine().toInt()
    bfs()
    println(answer)
    bw.flush()
}

private fun bfs() {
    val queue: Queue<Screen> = LinkedList()
    queue.add(Screen(1, 0, 0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        println("$q count : ${count++}")
        if (q.screenCnt == N) {
            answer = q.time
            break
        }
        queue.add(Screen(q.screenCnt, q.screenCnt, q.time + 1))
        if (q.cliboardCnt != 0) {
            if (q.screenCnt + q.cliboardCnt <= N) {
                queue.add(Screen(q.screenCnt + q.cliboardCnt, q.cliboardCnt, q.time + 1))
            }
        }
        if (q.screenCnt != 1) {
            queue.add(Screen(q.screenCnt - 1, q.cliboardCnt, q.time + 1))
        }
    }
}

data class Screen(
        var screenCnt: Int,
        var cliboardCnt: Int,
        var time: Int
)