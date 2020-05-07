package 백준

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

private lateinit var trace : Array<ArrayList<Int>>
private lateinit var dist : Array<Int>
private lateinit var map : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val (s, d) = br.readLine().split(" ").map { it.toInt() }
        dist = Array(n){200000000}
        map = Array(n){ IntArray(n) }
        trace = Array(n){ArrayList<Int>()}
        for (i in 0 until m) {
            val (u, v, p) = br.readLine().split(" ").map { it.toInt() }
            map[u][v] = p
        }
        dijkstra(s,d,n)
        traceBack(s,d,n)
        Arrays.fill(dist,200000000)
        println(dijkstra(s,d,n))
    }
    bw.flush()
}
private fun dijkstra(start: Int, end : Int,n:Int) : Int {
    val queue : PriorityQueue<Navigation> = PriorityQueue<Navigation>(Comparator.comparingInt { e1 -> e1.pos })
    queue.offer(Navigation(start,0))
    dist[start] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val curPos = q.pos
        val curDist = q.dist
        for (i in 0 until n) {
            if (map[curPos][i] != -1 && curDist + map[curPos][i] <= dist[i]) {
                dist[i] = curDist + map[curPos][i]
                queue.offer(Navigation(i, dist[i]))
                trace[i].add(curPos)
            }
        }
    }
    return if (dist[end] >= 200000000) dist[end] -1 else dist[end]
}
private fun traceBack(start : Int, end : Int,n:Int) {
    val queue : Queue<Int> = LinkedList()
    queue.offer(end)
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in trace[q]) {
            if (map[element][q] != -1 && dist[q] == map[element][q] + dist[element]) {
                queue.offer(element)
                map[element][q] = -1
            }
        }
    }
}
private data class Navigation(
        val pos : Int,
        val dist : Int
)