package 백준

import java.util.*
import kotlin.Comparator

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val queue : PriorityQueue<Conference> = PriorityQueue(Comparator<Conference> { t1 , t2 ->
        if (t1.end < t2.end) -1
        else if (t1.end == t2.end) {
            if (t1.start < t2.start) -1
            else 1
        }else 1
    })
    val answer : Stack<Conference> = Stack()
    for (i in 0 until  n) {
        val row = br.readLine().split(" ").map{it.toLong()}
        queue.offer(Conference(row[0],row[1]))
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (answer.isEmpty()) {
            answer.push(q)
        }else {
            if (answer.peek().end <= q.start) {
                answer.push(q)
            }
        }
    }
    println(answer.size)
    bw.flush()
}

private data class Conference(
        val start : Long,
        val end : Long
)