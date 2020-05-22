package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val s = br.readLine().toInt()
    val queue : Queue<Screen> = LinkedList()
    queue.offer(Screen(1,0,0))
    val visited = Array(1010){BooleanArray(1010)}
    visited[1][0] = true
    var answer =0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.screenCnt == s) {
            answer = q.time
            break
        }
        if (!visited[q.screenCnt][q.screenCnt]) {
            queue.offer(Screen(q.screenCnt,q.screenCnt,q.time+1))
            visited[q.screenCnt][q.screenCnt] = true
        }
        if (q.cliboardCnt != 0 && q.screenCnt + q.cliboardCnt < 1010 && !visited[q.screenCnt+q.cliboardCnt][q.cliboardCnt]) {
            queue.offer(Screen(q.screenCnt+q.cliboardCnt,q.cliboardCnt,q.time+1))
            visited[q.screenCnt+q.cliboardCnt][q.cliboardCnt] = true
        }
        if (q.screenCnt -1 >=0 && !visited[q.screenCnt-1][q.cliboardCnt]) {
            queue.offer(Screen(q.screenCnt-1,q.cliboardCnt,q.time+1))
            visited[q.screenCnt-1][q.cliboardCnt]= true
        }
    }
    println(answer)
    bw.flush()
}
private data class Screen(
        var screenCnt: Int,
        var cliboardCnt: Int,
        var time: Int
)