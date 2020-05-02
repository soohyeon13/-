package 백준

import java.util.*

private lateinit var arr : Array<IntArray>
private lateinit var visited : Array<BooleanArray>
private val queue : Queue<CleanBot> = LinkedList()
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n[0]){ IntArray(n[1]) }
    visited = Array(n[0]){BooleanArray(n[1])}
    val robot = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    queue.add(CleanBot(robot[0],robot[1],robot[2]))
    currentClear()
    println(answer)
    bw.flush()
}
private fun currentClear() {
    answer +=1
    val q = queue.poll()
    val saveDir = q.direction
    visited[q.x][q.y] = true
    secondOrder(q.x,q.y,q.direction,saveDir)
}
private fun secondOrder(x : Int, y: Int,dir : Int,save: Int) {
    println("x :$x y: $y dir :$dir sava :$save")
    val direction = if (dir == 0) 3 else dir-1
    val nx = x + dx[direction]
    val ny = y + dy[direction]
    if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) return
    if (save == direction) {
        val backX = x + dx[(direction +2)%4]
        val backY = y+ dy[(direction +2)%4]
        if (arr[backX][backY] == 1) return
        secondOrder(backX,backY,direction,save)
    }
    if (!visited[nx][ny] && arr[nx][ny] == 0) {
        queue.add(CleanBot(nx,ny, direction))
        currentClear()
    }else if (visited[nx][ny] || arr[nx][ny] == 1){
        secondOrder(x,y,direction,save)
    }

}
data class CleanBot(
        val x : Int,
        val y : Int,
        val direction : Int
)