package 백준

/*
* 메모리 초과
* */
import java.util.*
import kotlin.collections.ArrayList

private lateinit var treeMap: Array<ArrayList<Stub>>
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    var answerCount = 0
    treeMap = Array(N + 1) { ArrayList<Stub>() }
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        treeMap[row[0]].add(Stub(row[1], row[2]))
        treeMap[row[1]].add(Stub(row[0], row[2]))
    }
    val fox = moonLightFox(N)
    val wolf = moonLightWolf(N)
    println(fox.contentToString())
    println(wolf.contentToString())
    for (i in 1 .. N) {
        if (fox[i] < wolf[i]) answerCount++
    }
    println(answerCount)
}

private fun moonLightFox(n: Int): DoubleArray {
    val queue: Queue<MoonFox> = LinkedList()
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(MoonFox(1, 0))
    dist[1] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val curStub = q.end
        val curDist = q.distance
        if (curDist > dist[curStub]) continue
        for (i in treeMap[curStub].indices) {
            val nStub = treeMap[curStub][i].end
            val nDist = treeMap[curStub][i].cost
            if (dist[nStub] > curDist + nDist) {
                dist[nStub] = curDist + nDist
                queue.add(MoonFox(nStub, dist[nStub]))
            }
        }
    }
    return dist.map { it.toDouble() }.toDoubleArray()
}

private fun moonLightWolf(n: Int): DoubleArray {
    val queue: Queue<MoonWolf> = LinkedList()
    val dist = DoubleArray(n + 1) { Double.MAX_VALUE }
    val visited = BooleanArray(n + 1)
    visited[1] = true
    queue.add(MoonWolf(1, 0.0, true, visited))
    dist[1] = 0.0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val curStub = q.end
        val curDist = q.distance
        val curVisited = q.visited
        for (i in treeMap[curStub].indices) {
            val nStub = treeMap[curStub][i].end
            var nDist: Double
            val nHealth: Boolean
            if (q.health) {
                nDist = treeMap[curStub][i].cost.toDouble() / 2
                nHealth = false
            } else {
                nDist = treeMap[curStub][i].cost.toDouble() * 2
                nHealth = true
            }
            if (dist[nStub] > curDist + nDist) {
                dist[nStub] = curDist + nDist
            }
            if (!curVisited[nStub]) {
                val copyVisited = curVisited.copyOf()
                copyVisited[nStub] = true
                queue.add(MoonWolf(nStub, curDist + nDist, nHealth, copyVisited))
            }
        }
    }
    return dist
}

private data class Stub(
        val end: Int,
        val cost: Int
)

private data class MoonFox(
        val end: Int,
        val distance: Int
)

private data class MoonWolf(
        val end: Int,
        val distance: Double,
        val health: Boolean,
        val visited: BooleanArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoonWolf

        if (end != other.end) return false
        if (distance != other.distance) return false
        if (health != other.health) return false
        if (!visited.contentEquals(other.visited)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = end
        result = 31 * result + distance.hashCode()
        result = 31 * result + health.hashCode()
        result = 31 * result + visited.contentHashCode()
        return result
    }
}