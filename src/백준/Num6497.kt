package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var parent: IntArray
fun main() {
    val input = System.`in`.bufferedReader()
    while (true) {
        val (m, n) = input.readLine().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) break
        val loadMap = Array(n) { House() }
        parent = IntArray(m) { i -> i }
        var distanceSum = 0
        for (i in 0 until n) {
            val row = input.readLine().split(" ").map { it.toInt() }
            distanceSum += row[2]
            loadMap[i] = House(row[0], row[1], row[2])
        }
        loadMap.sortBy { it.distance }
        var distanceCost = 0
        for (i in 0 until n) {
            val rootX = findRoot(loadMap[i].start)
            val rootY = findRoot(loadMap[i].end)

            if (rootX == rootY) continue
            else {
                parent[rootX] = rootY
                distanceCost += loadMap[i].distance
            }
        }
        println(distanceSum - distanceCost)

    }
}

private fun findRoot(u: Int): Int {
    if (u == parent[u]) return u
    else {
        parent[u] = findRoot(parent[u])
        return parent[u]
    }
}

private data class House(
        val start: Int = 0,
        val end: Int = 0,
        val distance: Int = 0
)