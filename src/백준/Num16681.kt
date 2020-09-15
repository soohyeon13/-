package 백준
import java.util.*
import kotlin.collections.ArrayList

private lateinit var distanceMap: Array<ArrayList<Climbing>>
private var distanceBasedHealth = 0
private var heightBasedAchieve = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M, D, E) = input
            .readLine()
            .split(" ")
            .map { it.toInt() }
    distanceBasedHealth = D
    heightBasedAchieve = E
    distanceMap = Array(N + 1) { ArrayList<Climbing>() }
    val heights = input.readLine().split(" ").map { it.toInt() }
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        distanceMap[row[0]].add(Climbing(row[1], row[2]))
        distanceMap[row[1]].add(Climbing(row[0], row[2]))
    }
    val fromTheFirst = getShortestDistance(1, N, heights)
    val fromTheLast = getShortestDistance(N, N, heights)
    val sum = IntArray(N + 1)
    var valueMaximum = Int.MIN_VALUE
    for (i in 2 until N) {
        if (fromTheFirst[i] == Int.MAX_VALUE || fromTheLast[i] == Int.MAX_VALUE) continue
        else {
            sum[i] = (heights[i - 1] * heightBasedAchieve) - fromTheFirst[i] - fromTheLast[i]
            if (valueMaximum < sum[i]) valueMaximum = sum[i]
        }
    }
    if (valueMaximum == Int.MIN_VALUE) println("Impossible")
    else println(valueMaximum)
}

private fun getShortestDistance(start: Int, n: Int, heights: List<Int>): IntArray {
    val queue: Queue<Climbing> = LinkedList()
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(Climbing(start, 0))
    dist[1] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in distanceMap[q.end].indices) {
            val nNode = distanceMap[q.end][i].end
            val nDist = distanceMap[q.end][i].distance * distanceBasedHealth
            if (heights[q.end - 1] < heights[nNode - 1]) {
                if (dist[nNode] > q.distance + nDist) {
                    dist[nNode] = q.distance + nDist
                    queue.add(Climbing(nNode, q.distance + nDist))
                }
            }
        }
    }
    return dist
}

private data class Climbing(
        val end: Int,
        val distance: Int
)