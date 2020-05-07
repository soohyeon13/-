package 백준

import java.util.*

private lateinit var map : Array<IntArray>
private val queue : Queue<BabyShark> = LinkedList()
private lateinit var visited :Array<BooleanArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,-1,0,1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    map = Array(n){ IntArray(n) }
    visited = Array(n){ BooleanArray(n) }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
            if (row[j] == 9) {
                queue.add(BabyShark(i,j,0,2))
            }
        }
    }
    sharkMove()
}
private fun sharkMove() {
    val q = queue.poll()
    for (i in 0 until 4) {
        val nx = q.x + dx[i]
        val ny = q.y + dy[i]
    }
}

data class BabyShark(
        val x : Int,
        val y : Int,
        var distance : Int,
        var size : Int
)