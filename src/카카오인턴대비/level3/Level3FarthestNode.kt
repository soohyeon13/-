package 카카오인턴대비.level3

import java.util.*

class Level3FarthestNode {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val distance = Array(n + 1) { 0 }
        val edgeMap = Array(n + 1) { BooleanArray(n + 1) }
        val queue: Queue<Int> = LinkedList()
        for (i in edge.indices) {
            edgeMap[edge[i][0]][edge[i][1]] = true
            edgeMap[edge[i][1]][edge[i][0]] = true
        }
        queue.add(1)
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (i in 2..n) {
                if (edgeMap[q][i] && distance[i] == 0) {
                    distance[i] = distance[q] + 1
                    queue.add(i)
                }
            }
        }
        return distance.sortedByDescending { it }.groupBy { it }.toList().first().second.size
    }
}