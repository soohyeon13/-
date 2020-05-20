package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var map: Array<ArrayList<Artist>>
private lateinit var dist: Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val (n, m, f) = br.readLine().split(" ").map { it.toInt() }
        val (s, g, h) = br.readLine().split(" ").map { it.toInt() }
        map = Array(n + 1) { ArrayList<Artist>() }
        dist = Array(n + 1) { 20000000 }
        for (j in 0 until m) {
            val (a, b, d) = br.readLine().split(" ").map { it.toInt() }
            if ((a == g && b == h) || (a == h && b == g)) {
                map[a].add(Artist(b, (d * 2) - 1))
                map[b].add(Artist(a, (d * 2) - 1))
            } else {
                map[a].add(Artist(b, d * 2))
                map[b].add(Artist(a, d * 2))
            }
        }
        dijkstra(s)
        val answer = ArrayList<Int>()
        val sb = StringBuilder()
        for (j in 0 until f) {
            val sub = br.readLine().toInt()
            if (dist[sub] % 2 != 0) answer.add(sub)
        }
        answer.sort()
        for (j in answer.indices) {
            sb.append(answer[j]).append(" ")
        }
        println(sb.toString().trim())
    }
    bw.flush()
}

private fun dijkstra(start: Int) {
    val queue: Queue<Artist> = LinkedList()
    queue.offer(Artist(start, 0))
    dist[start] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in map[q.end]) {
            if (dist[element.end] > dist[q.end] + element.cost) {
                dist[element.end] = dist[q.end] + element.cost
                queue.offer(Artist(element.end, dist[element.end]))
            }
        }
    }
}

private data class Artist(
        val end: Int,
        val cost: Int
)