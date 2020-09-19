package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
    val input = System.`in`.bufferedReader()
    while (true) {
        val (N, M) = input.readLine().split(" ").map { it.toInt() }
        if (N == 0 && M == 0) break
        val (S,D) = input.readLine().split(" ").map { it.toInt() }
        val loadMap = Array(N){ArrayList<Load>()}
        for (i in 0 until M) {
            val row = input.readLine().split(" ").map { it.toInt()}
            loadMap[row[0]].add(Load(row[1],row[2]))
        }
        val queue : Queue<LoadPath> = LinkedList()
        val dist = IntArray(N){Int.MAX_VALUE}
        val shortPoints = HashSet<Int>()
        dist[S] = 0
        queue.add(LoadPath(Load(S,0), intArrayOf()))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            val curLoad = q.load
            val curPath = q.path
            for (j in loadMap[curLoad.end].indices) {
                val nNode = loadMap[curLoad.end][j].end
                val nDist = loadMap[curLoad.end][j].distance
                if (dist[nNode] > curLoad.distance + nDist) {
                    dist[nNode] = curLoad.distance + nDist
                    val nPath = curPath + nNode
                    if (nNode == D) {
                        shortPoints.clear()
                        shortPoints.addAll(curPath.toCollection(HashSet<Int>()))
                    }
                    queue.add(LoadPath(Load(nNode,dist[nNode]),nPath))
                }else if (dist[nNode] == curLoad.distance + nDist) {
                    if (nNode == D) {
                        shortPoints.addAll(curPath.toCollection(HashSet<Int>()))
                    }
                }
            }
        }
        val answer = getNearlyShortestDist(N,S,D,shortPoints.toIntArray(),loadMap)
        if (answer == Int.MAX_VALUE) println(-1)
        else println(answer)
    }
}

private fun getNearlyShortestDist(n : Int,start:Int,end:Int,points:IntArray,loadMap:Array<ArrayList<Load>>): Int {
    val queue : Queue<Load> = LinkedList()
    val dist = IntArray(n){Int.MAX_VALUE}
    dist[start] = 0
    queue.add(Load(start,0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val curNode = q.end
        val curDist = q.distance
        for (i in loadMap[curNode].indices) {
            val nNode = loadMap[curNode][i].end
            val nDist = loadMap[curNode][i].distance
            if (points.contains(nNode)) continue
            if (dist[nNode] > curDist + nDist) {
                dist[nNode] = curDist + nDist
                queue.add(Load(nNode,dist[nNode]))
            }
        }
    }
    return dist[end]
}

private data class Load(
        val end:Int,
        val distance:Int
)

private data class LoadPath(
        val load:Load,
        val path:IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LoadPath

        if (load != other.load) return false
        if (!path.contentEquals(other.path)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = load.hashCode()
        result = 31 * result + path.contentHashCode()
        return result
    }
}