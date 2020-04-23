package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<IntArray>
private lateinit var visit: Array<BooleanArray>
private lateinit var waterVisit : Array<BooleanArray>
private val waterArr = ArrayList<IntArray>()
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var answer = -2
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val N = br.readLine().split(" ").map { it.toInt() }
    val n = N[0]
    val m = N[1]
    arr = Array(n) { IntArray(m) }
    visit = Array(n) { BooleanArray(m) }
    waterVisit = Array(n){ BooleanArray(m) }
    var start = IntArray(2)
    for (i in 0 until n) {
        val row = br.readLine().toCharArray()
        for (j in 0 until m) {
            when (row[j]) {
                'D' -> arr[i][j] = 1
                '.' -> arr[i][j] = 0
                'S' -> {
                    arr[i][j] = 2
                    visit[i][j] = true
                    start = intArrayOf(i,j)
                }
                '*' -> {
                    arr[i][j] = 3
                    waterVisit[i][j] = true
                    waterArr.add(intArrayOf(i,j))
                }
                'X' -> arr[i][j] = -1
            }
        }
    }

    bfs(start,n,m)
    if (answer == -2) println("KAKTUS")
    else println(answer)
    bw.flush()
}

private fun bfs(start: IntArray,n:Int,m:Int) {
    val queue : Queue<Hedgehog> = LinkedList()
    val waterQueue : Queue<Water> = LinkedList()
    queue.add(Hedgehog(start[0],start[1],0))
    for (i in waterArr.indices) {
        waterQueue.add(Water(waterArr[i][0], waterArr[i][1]))
    }
    loop@while (!queue.isEmpty()) {
        val wSize = waterQueue.size
        val qSize = queue.size
        for (i in 0 until wSize) {
            val w = waterQueue.poll()
            for (j in 0 until 4) {
                val wnx = w.x + dx[j]
                val wny = w.y + dy[j]
                if (wnx <0 || wny < 0 || wnx >= n || wny >= m) continue
                if (waterVisit[wnx][wny]) continue
                if (arr[wnx][wny] == 0 ||arr[wnx][wny] == 2) {
                    waterVisit[wnx][wny] =true
                    waterQueue.add(Water(wnx,wny))
                }
            }
        }
        for (t in 0 until qSize) {
            val q = queue.poll()
            if (arr[q.x][q.y] == 1) {
                answer = q.count
                break@loop
            }
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                if (waterVisit[nx][ny]) continue
                if (arr[nx][ny] == -1 || visit[nx][ny]) continue
                visit[nx][ny] = true
                queue.add(Hedgehog(nx,ny,q.count+1))
            }
        }

    }
}
data class Water(
        val x : Int,
        val y : Int
)

data class Hedgehog(
        val x : Int,
        val y : Int,
        var count : Int
)