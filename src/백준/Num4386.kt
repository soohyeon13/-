package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

private lateinit var parent: IntArray
fun main() {
    val input = System.`in`.bufferedReader()
    val n = input.readLine().toInt()
    val starMap = ArrayList<Star>()
    for (i in 0 until n) {
        val row = input.readLine().split(" ").map { it.toDouble() }
        starMap.add(Star(row[0], row[1], i))
    }
    val starEdges = ArrayList<Edge>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val weight =
                    sqrt(Math.pow(starMap[i].x - starMap[j].x, 2.0) + Math.pow(starMap[i].y - starMap[j].y, 2.0))
            starEdges.add(Edge(starMap[i].num, starMap[j].num, weight))
        }
    }
    val sortStarEdges=starEdges.sortedBy { it.weight }
    parent = IntArray(n){i -> i}
    var answer = 0.0

    for (i in sortStarEdges.indices) {
        val edge =sortStarEdges[i]
        if (find(edge.start)!= find(edge.end)) {
            answer += edge.weight
            union(edge.start,edge.end)
        }
    }
    println(answer)
}

private fun find(x :Int): Int {
    if (x == parent[x]) return x
    parent[x]=find(parent[x])
    return parent[x]
}

private fun union(x:Int,y:Int) {
    var copyX= x
    var copyY = y
    copyX= find(x)
    copyY = find(y)
    if (copyX != copyY) {
        parent[copyY] = copyX
    }
}

private data class Star(
        val x: Double,
        val y: Double,
        val num: Int
)

private data class Edge(
        val start: Int,
        val end: Int,
        val weight: Double
)

