package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var dist: Array<Int>
private lateinit var edge: Array<ArrayList<Path>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val visited = Array(n[0] +1) { false }
    val k = br.readLine().toInt()
    val queue  = PriorityQueue<Int>()
    dist = Array(n[0] + 1) { Int.MAX_VALUE }
    edge = Array(n[0] + 1) { ArrayList<Path>() }
    for (i in 0 until n[1]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        edge[row[0]].add(Path(row[1], row[2]))
    }
    queue.add(k)
    dist[k] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        visited[q] = true
        for (element in edge[q]) {
            if (dist[element.end] > dist[q] + element.weight) {
                dist[element.end] = dist[q] + element.weight
                queue.add(element.end)
            }
        }
    }
    for (i in 1 .. n[0]) {
        if(visited[i]) println(dist[i])
        else println("INF")
    }
    bw.flush()
}
private data class Path(
        val end: Int,
        val weight: Int
)