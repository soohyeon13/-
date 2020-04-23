package 백준

import java.util.*
import kotlin.collections.ArrayList

private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private lateinit var arr: Array<CharArray>
private val iceQueue: Queue<Ice> = LinkedList()
private val swan = ArrayList<Swan>()
private var answer =0
private var N =0
private var M = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    N = n[0]
    M = n[1]
    val iceVisit = Array(N){BooleanArray(M)}
    arr = Array(N){ CharArray(M) }
    for (i in 0 until N) {
        val row = br.readLine().toCharArray()
        for (j in 0 until M) {
            arr[i][j] = row[j]
            if (j <= M-2 && row[j] == '.' && row[j + 1] == 'X') {
                if (!iceVisit[i][j]) iceQueue.add(Ice(i, j,0))
                iceVisit[i][j] = true
            }
            else if (j <= M-2 && row[j] == 'X' && row[j + 1] == '.') {
                if (!iceVisit[i][j+1]) iceQueue.add(Ice(i, j+1,0))
                iceVisit[i][j+1] =true
            }
            if (row[j] == 'L') swan.add(Swan(i, j))
        }
    }
    bfs()
    println(answer)
    bw.flush()
}

private fun bfs() {
    while (true) {
        if (swanBfs()) {
            break
        }
        val iceSize = iceQueue.size
        for (i in 0 until iceSize) {
            val ice = iceQueue.poll()
            for (j in 0 until 4) {
                val inx = ice.x + dx[j]
                val iny = ice.y + dy[j]
                if (inx < 0 || iny < 0 || inx >= N || iny >= M) continue
                if (arr[inx][iny] == '.') continue
                if (arr[inx][iny] == 'X') {
                    arr[inx][iny] = '.'
                    iceQueue.add(Ice(inx,iny, ice.day+1))
                    answer = ice.day +1
                }
            }
        }
    }
}
private fun swanBfs() : Boolean {
    val swapVisit = Array(N){BooleanArray(M)}
    val queue : Queue<Swan> = LinkedList()
    queue.add(Swan(swan[0].x, swan[0].y))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        swapVisit[q.x][q.y] = true
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0|| ny<0 || nx >= N || ny>= M) continue
            if (swapVisit[nx][ny]) continue
            if (arr[nx][ny] == 'X') continue
            if (nx == swan[1].x && ny == swan[1].y) return true
            swapVisit[nx][ny] = true
            queue.add(Swan(nx,ny))
        }
    }
    return false
}
data class Swan(
        val x: Int,
        val y: Int
)

data class Ice(
        val x: Int,
        val y: Int,
        var day: Int
)