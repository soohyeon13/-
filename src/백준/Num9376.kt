package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<Array<String>>
private lateinit var doorCnt: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var N = 0
private var M = 0
private var answer = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    for (t in 0 until n) {
        val range = br.readLine().split(" ").map { it.toInt() }
        N = range[0]
        M = range[1]
        arr = Array(N) { Array(M) { "" } }
        doorCnt = Array(N) { IntArray(M) }
        val prisoner = ArrayList<IntArray>()
        for (i in 0 until N) {
            val row = br.readLine().toCharArray().map { it.toString() }
            for (j in 0 until M) {
                arr[i][j] = row[j]
                if (row[j] == "$") prisoner.add(intArrayOf(i, j))
            }
        }
        bfs(prisoner)
        println(answer)
    }
}

private fun bfs(p: ArrayList<IntArray>) {
    val queue: Queue<Prisoner> = LinkedList()
    for (i in p.indices) {
        queue.add(Prisoner(p[i][0], p[i][1],0))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.x == 0 || q.y == 0 || q.x == N-1 || q.y == M-1) {
                answer = Math.min(q.count, answer)
                continue
            }
            for (j in 0 until 4) {
                val nx = q.x + dx[j]
                val ny = q.y + dy[j]
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
                if (arr[nx][ny] == "#") {
                    arr[nx][ny] = "."
                    queue.add(Prisoner(nx,ny,q.count+1))
                }else if (arr[nx][ny] == ".") {
                    queue.add(Prisoner(nx,ny,q.count))
                }
            }
        }
    }
}

data class Prisoner(
        val x: Int,
        val y: Int,
        var count : Int
)
































