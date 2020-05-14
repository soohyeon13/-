package 윈터코딩2018

import java.util.*

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
class LandMove {
    fun solution(land: Array<IntArray>, height: Int): Int {
        val dist = Array(land.size){IntArray(land.size){10000}}
        val queue : Queue<Land> = LinkedList()
        queue.offer(Land(0,0))
        dist[0][0] = 0
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= land.size || ny >= land.size) continue
                if (dist[nx][ny] > Math.abs(land[q.x][q.y]-land[nx][ny])) {
                    if (Math.abs(land[q.x][q.y]-land[nx][ny]) <= height) {
                        dist[nx][ny] = 0
                    }else {
                        dist[nx][ny] = Math.abs(land[q.x][q.y]-land[nx][ny])
                    }
                    queue.offer(Land(nx,ny))
                }
            }
        }
        dist.forEach { println(it.contentToString()) }
    }
    data class Land(
            val x : Int,
            val y : Int
    )
}