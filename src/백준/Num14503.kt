package 백준

import java.util.*

private lateinit var arr : Array<IntArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private val dir = intArrayOf(0,1,2,3)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n[0]){ IntArray(n[1]) }
    val visited = Array(n[0]){BooleanArray(n[1])}
    val robot = br.readLine().split(" ").map { it.toInt() }
    val queue : Queue<CleanBot> = LinkedList()
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    queue.add(CleanBot(robot[0],robot[1],robot[2]))
    while (true) {
        val q = queue.poll()
        visited[q.x][q.y] = true

        if (visited[][])
    }
}
data class CleanBot(
        val x : Int,
        val y : Int,
        val direction : Int
)