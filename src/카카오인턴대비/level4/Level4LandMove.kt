package 카카오인턴대비.level4

import java.util.*

class Level4LandMove {
    private val dx = intArrayOf(-1,0,1,0)
    private val dy = intArrayOf(0,1,0,-1)
    fun solution(land:Array<IntArray>,height:Int):Int {
        val queue : Queue<Land> = LinkedList()
        val visited = Array(land.size){BooleanArray(land.size)}
        var answer = Int.MAX_VALUE
        queue.add(Land(0,0,0))
        visited[0][0] = true
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= land.size || ny >= land.size) {
                    continue
                }
                val a = Math.abs(land[q.x][q.y] - land[nx][ny])
                if (a <= height &&!visited[nx][ny]) {
                    queue.add(Land(nx,ny,q.ladder))
                }else if(a <= height) {
                    queue.add(Land(nx,ny,q.ladder))
                }else {
                    queue.add(Land(nx,ny,q.ladder+1))
                }
                visited[nx][ny] = true
                if (q.ladder < answer) answer = q.ladder
            }
        }
        return answer
    }
    data class Land(
            val x : Int,
            val y : Int,
            val ladder : Int
    )
}