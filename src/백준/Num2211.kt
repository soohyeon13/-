package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var map : Array<ArrayList<NetWork>>
private lateinit var dist : Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n+1){ArrayList<NetWork>()}
    dist = Array(n+1){10001}
    val queue : Queue<NetWork> = LinkedList()
    for (i in 0 until m) {
        val (a,b,c) = br.readLine().split(" ").map { it.toInt() }
        map[a].add(NetWork(b,c))
        map[b].add(NetWork(a,c))
    }
    dist[1] = 0
    queue.offer(NetWork(1,0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in map[q.end]) {
            if (dist[element.end] > dist[q.end] + element.cost) {
                dist[element.end] = dist[q.end] + element.cost
                queue.offer(NetWork(element.end, dist[element.end]))
            }
        }
    }
    println(n-1)
    val qu : Queue<Way> = LinkedList()
    val q : Queue<Int> = LinkedList()
    val visited  =BooleanArray(n+1)
    q.offer(1)
    visited[1] = true
    var now = 0
    while (!q.isEmpty()) {
        now = q.poll()
        for (element in map[now]) {
            qu.offer(Way(now,element.end,element.cost + dist[now]))
        }
        while (!qu.isEmpty()) {
            val w = qu.poll()
            if (!visited[w.end] && w.cost == dist[w.end]) {
                println("${w.start} ${w.end}")
                q.offer(w.end)
                visited[w.end] = true
                break
            }
        }
    }
    bw.flush()
}

private data class Way(
        val start : Int,
        val end : Int,
        val cost : Int
)

private data class NetWork(
        val end : Int,
        val cost : Int
)
