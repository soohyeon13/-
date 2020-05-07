package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(n+1){ ArrayList<AirPlane>()}
        val queue : Queue<AirPlane> = LinkedList()
        for (j in 0 until k) {
            val (u,v,c,d) = br.readLine().split(" ").map { it.toInt() }
            arr[u].add(AirPlane(v,c,d))
        }
        queue.add(AirPlane(1,0,0))
        var answer = Int.MAX_VALUE
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.end == n) answer = if (answer > q.time) q.time else answer
            for (element in arr[q.end]) {
                if (element.cost + q.cost <= m) {
                    queue.offer(AirPlane(element.end,element.cost+ q.cost,element.time + q.time))
                }
            }
        }
        if (answer >= 100001) println("Poor KCM")
        else println(answer)
    }
    bw.flush()
}

private data class AirPlane(
        val end: Int,
        val cost : Int,
        val time : Int
)