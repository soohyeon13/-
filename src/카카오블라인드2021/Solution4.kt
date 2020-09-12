package 카카오블라인드2021

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

private lateinit var load: Array<ArrayList<Taxi>>

class Solution4 {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Long = 600000000
        load = Array(n + 1) { ArrayList<Taxi>() }
        for (i in fares.indices) {
            load[fares[i][1]].add(Taxi(fares[i][0], fares[i][2].toLong()))
            load[fares[i][0]].add(Taxi(fares[i][1], fares[i][2].toLong()))
        }
        val shortS = calculateLoad(s, n)
        val shortA = calculateLoad(a, n)
        val shortB = calculateLoad(b, n)
        println(shortS.contentToString())
        println(shortA.contentToString())
        println(shortB.contentToString())
        for (i in 1..n) {
            answer = min(answer, (shortA[i] + shortB[i] + shortS[i]))
        }
        return answer.toInt()
    }

    private fun calculateLoad(start: Int, n: Int): LongArray {
        val dist = LongArray(n + 1) { 600000000 }
        val queue: Queue<Taxi> = LinkedList()
        queue.add(Taxi(start, 0))
        dist[start] = 0
        while (!queue.isEmpty()) {
            val q = queue.poll()
            val curNode = q.end
            val curCost = q.cost

            if (curCost > dist[curNode]) continue

            for (i in load[curNode].indices) {
                val nNode = load[curNode][i].end
                val nCost = load[curNode][i].cost
                if (dist[nNode] >= curCost + nCost) {
                    dist[nNode] = curCost + nCost
                    queue.add(Taxi(nNode, dist[nNode]))
                }
            }
        }
        return dist
    }
}

private data class Taxi(
        val end: Int,
        val cost: Long
)