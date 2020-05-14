package 윈터코딩2018

import java.util.*
import kotlin.collections.ArrayList

class Delivery {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val map = Array(N+1){ ArrayList<DT>()}
        val queue : Queue<DT> = LinkedList()
        val dist = Array(N+1){25000001}
        for (i in road.indices) {
            map[road[i][0]].add(DT(road[i][1],road[i][2]))
            map[road[i][1]].add(DT(road[i][0],road[i][2]))
        }
        dist[1] = 0
        queue.offer(DT(1,0))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (element in map[q.end]) {
                if (dist[element.end] > dist[q.end] + element.cost) {
                    dist[element.end] = dist[q.end] + element.cost
                    queue.offer(DT(element.end,dist[element.end]))
                }
            }
        }
        var answer = 0
        for (i in 1 until dist.size) {
            if (dist[i] <= k) answer +=1
        }
        return answer
    }
    data class DT(
            val end : Int,
            val cost : Int
    )
}