package skillcheck3

import java.util.*
import kotlin.collections.ArrayList

class Solution3 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val arr = Array(N+1){ArrayList<Sol3>()}
        for (i in road.indices) {
            arr[road[i][0]].add(Sol3(road[i][1],road[i][2]))
            arr[road[i][1]].add(Sol3(road[i][0],road[i][2]))
        }
        val dist = Array(N+1){1000000}
        dist[1] = 0
        val queue : Queue<Sol3> = LinkedList()
        queue.offer(Sol3(1,0))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (element in arr[q.end]) {
                if (dist[element.end] > dist[q.end] + element.cost) {
                    dist[element.end] = dist[q.end] + element.cost
                    queue.offer(Sol3(element.end,dist[element.end]))
                }
            }
        }
        var answer = 0
        for (i in 1 until dist.size) {
            if (dist[i] <=k) {
                answer +=1
            }
        }
        return answer
    }
}
private data class Sol3 (
        val end : Int,
        val cost : Int
)