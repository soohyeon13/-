package 백준

import java.util.*

private lateinit var map: Array<Array<String>>
private lateinit var visited : Array<BooleanArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var red = Boll()
private var blue = Boll()
private var goal = Boll()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var answer =0
    map = Array(n) { Array(m) { "" } }
    visited = Array(n){ BooleanArray(m) }
    for (i in 0 until n) {
        val row = br.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            map[i][j] = row[j]
            if (row[j] == "R") red = Boll(i,j)
            if (row[j] == "B") blue = Boll(i,j)
            if (row[j] == "O") goal = Boll(i,j)
        }
    }
    val queue : Queue<Bolls> = LinkedList()
    queue.offer(Bolls(red,blue,0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.time >10) continue
        if (q.blue == goal) continue
        if (q.red == goal && q.blue != goal ) {
            answer = q.time
            break
        }
        for (i in 0 until 4) {
            if (moveBoll(q.red.x,q.red.y,i,"red") ==
                    moveBoll(q.blue.x,q.blue.y,i,"blue")){

            }
        }
    }
    println(answer)
    bw.flush()
}
private fun moveBoll(x:Int? , y: Int?,dir : Int,kind : String) : Int {
    var nx = x!!
    var ny = y!!
    var cnt = 0
    while (map[nx][ny] != "#") {
        nx += dx[dir]
        ny += dy[dir]
        if (map[nx][ny] == "O") {
            if (kind == "red") red = Boll(nx,ny)
            else blue = Boll(nx,ny)
            return cnt
        }
        cnt++
    }
    nx -= dx[dir]
    ny -= dy[dir]
    if (kind == "red") red = Boll(nx,ny)
    else blue = Boll(nx,ny)
    return cnt-1
}
private data class Bolls(
        val red : Boll,
        val blue : Boll,
        val time : Int
)
private data class Boll(
        val x: Int? =0,
        val y: Int? =0
)