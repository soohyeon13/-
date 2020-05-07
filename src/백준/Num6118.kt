package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var map : Array<ArrayList<Farm>>
private lateinit var dist : Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n+1) { ArrayList<Farm>() }
    dist = Array(n+1) { 1000001}
    for (i in 0 until m) {
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        map[a].add(Farm(b,1))
        map[b].add(Farm(a,1))
    }
    dist[1] = 0
    val queue: Queue<Farm> = LinkedList()
    queue.add(Farm(1,0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in map[q.end]) {
            if (dist[element.end] > dist[q.end] + element.cost) {
                dist[element.end] = dist[q.end] + element.cost
                queue.offer(Farm(element.end, dist[element.end]))
            }
        }
    }
    for (i in dist.indices) {
        if (dist[i] == 1000001) dist[i] = 0
    }
    val max = dist.max()!!
    var answerCnt = 0
    val pq = PriorityQueue<Int>()
    for (i in 1..n) {
        if (dist[i] == max) {
            answerCnt +=1
            pq.offer(i)
        }
    }
    println("${pq.poll()} $max $answerCnt")
    bw.flush()
}
private data class Farm(
        val end : Int,
        val cost : Int
)
