package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val v = br.readLine().toInt()
    val edge = br.readLine().toInt()
    val map = Array(v+1){ArrayList<Bus>()}
    val dist = Array(v+1) { Int.MAX_VALUE }
    val visited = Array(v+1) { false }
    for (i in 0 until edge) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]].add(Bus(row[1],row[2]))
    }
    val destination = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Int>()
    queue.add(destination[0])
    dist[destination[0]] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in map[q]) {
            if (dist[element.end] > dist[q] + element.cost) {
                dist[element.end] = dist[q] + element.cost
                queue.add(element.end)
            }
        }
    }
    println(dist[destination[1]])
    bw.flush()
}

private data class Bus(
        val end : Int,
        val cost : Int
)