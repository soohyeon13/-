package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var busStopMap: Array<ArrayList<BusStop>>
private const val FIND_SUCCESS = "SAVE HIM"
private const val FIND_FALSE = "GOOD BYE"
fun main() {
    val input = System.`in`.bufferedReader()
    val (V, E, P) = input.readLine().split(" ").map { it.toInt() }
    busStopMap = Array(V + 1) { ArrayList<BusStop>() }
    for (i in 0 until E) {
        val row = input.readLine().split(" ").map { it.toInt() }
        busStopMap[row[0]].add(BusStop(row[1], row[2]))
        busStopMap[row[1]].add(BusStop(row[0], row[2]))
    }
    val fullPath = findPath(V, 1)
    val endToStartPath = findPath(V,V)

    val friendShortLen = endToStartPath[P] + fullPath[P]
    if (endToStartPath[1] != friendShortLen) println(FIND_FALSE)
    else println(FIND_SUCCESS)
}

private fun findPath(v: Int, start: Int): IntArray {
    val queue: Queue<BusStop> = LinkedList()
    val dist = IntArray(v + 1) { Int.MAX_VALUE }
    dist[start] = 0
    queue.add(BusStop(start, 0))
    while (!queue.isEmpty()) {
        val busStop = queue.poll()
        val curNode = busStop.end
        val curDist = busStop.distance
        for (i in busStopMap[curNode].indices) {
            val nNode = busStopMap[curNode][i].end
            val nDist = busStopMap[curNode][i].distance
            if (dist[nNode] > curDist + nDist) {
                dist[nNode] = curDist + nDist
                queue.add(BusStop(nNode, dist[nNode]))
            }
        }
    }
    return dist
}

private data class BusStop(
        val end: Int,
        val distance: Int
)