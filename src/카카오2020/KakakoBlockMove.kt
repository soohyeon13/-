package 카카오2020

import java.util.*

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private val queue : Queue<KakakoBlockMove.Drone> = LinkedList()
private lateinit var visited : Array<Array<BooleanArray>>
class KakakoBlockMove {
    fun solution(board : Array<IntArray>) : Int {
        val n = board.size
        visited = Array(n){ Array(n){ BooleanArray(2) } }
        bfs(board)
        return 0
    }
    private fun bfs(board: Array<IntArray>) {
        val n = board.size
        val front = Node(0,0)
        val end = Node(0,1)
        queue.add(Drone(front,end,0,0))
        visited[0][0][0] = true
        visited[0][1][0] = true
        while (!queue.isEmpty()) {
            val q = queue.poll()
            for (i in dx.indices) {
                val nxFront = nextArea(q.front,i)
                val nxEnd = nextArea(q.end,i)
                if (!isRangeCheck(nxFront,n) && !isRangeCheck(nxEnd,n)) continue
                if (visited[nxFront.x][nxFront.y][q.condition] &&
                        visited[nxEnd.x][nxEnd.y][q.condition]) continue
                visited[nxFront.x][nxFront.y][q.condition] = true
                visited[nxEnd.x][nxEnd.y][q.condition] = true
                queue.offer(Drone(nxFront,nxEnd,q.condition,q.cnt+1))
            }
            droneRotate(q)
        }
    }
    private fun droneRotate(drone: Drone) {

    }

    private fun rotateRangeCheck(front : Node,end: Node,cond : Int) : Boolean {

        return true
    }

    private fun nextArea(node : Node,i : Int) : Node {
        val nx = node.x + dx[i]
        val ny = node.y + dy[i]
        return Node(nx,ny)
    }

    private fun isRangeCheck(node: Node,n:Int) : Boolean {
        return !(node.x <0 || node.y < 0 || node.x>=n || node.y>= n)
    }

    data class Drone(
            val front : Node,
            val end : Node,
            val condition : Int,
            val cnt : Int
    )

    data class Node(
            val x : Int,
            val y : Int
    )
}