package 백준

import java.util.*

private lateinit var arr : Array<IntArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private val answer = PriorityQueue<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    arr = Array(n){IntArray(n)}
    for (i in 0 until n) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 1) {
                bfs(i,j)
            }
        }
    }
    println(answer.size)
    for (i in answer.indices) {
        println(answer.poll())
    }
    bw.flush()
}

private fun bfs(a : Int, b : Int) {
    val queue : Queue<Home> = LinkedList()
    var cnt = 0
    queue.add(Home(a,b))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr.size) continue
            if (arr[nx][ny] == 1) {
                cnt++
                queue.add(Home(nx,ny))
                arr[nx][ny] = 0
            }
        }
    }
    arr.forEach { println(it.contentToString()) }
    println("---------------------------------------")
    answer.add(cnt)
}

data class Home(
        val x : Int,
        val y : Int
)