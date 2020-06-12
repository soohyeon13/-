package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var map: Array<IntArray>
private lateinit var copy : Array<IntArray>
private val virusList = ArrayList<Virus>()
private var answer = 0
private var N = 0
private var M = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    map = Array(n) { IntArray(m) }
    copy = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
            if (row[j] == 2) virusList.add(Virus(i, j))
        }
    }
    setWall(0,0)
    println(answer)
    bw.flush()
}

private fun setWall(start: Int, depth: Int) {
    if (depth == 3) {
        expandVirus()
        return
    }
    for (i in start until N * M) {
        val x = i / M
        val y = i % M
        if (map[x][y] == 0) {
            map[x][y] = 1
            setWall(i+1,depth +1)
            map[x][y] = 0
        }
    }
}
private fun copyMap() {
    for (i in copy.indices) {
        for (j in copy[i].indices) {
            copy[i][j] = map[i][j]
        }
    }
}

private fun expandVirus() {
    val queue: Queue<Virus> = LinkedList()
    copyMap()
    for (i in virusList.indices) {
        queue.offer(virusList[i])
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= copy.size || ny >= copy[0].size) continue
            if (copy[nx][ny] == 0) {
                copy[nx][ny] = 2
                queue.offer(Virus(nx, ny))
            }
        }
    }
    checkClean()
}

private fun checkClean() {
    var cnt = 0
    for (i in copy.indices) {
        for (j in copy[i].indices) {
            if (copy[i][j] == 0) cnt += 1
        }
    }
    answer = max(answer,cnt)
}

private data class Virus(
        val x: Int,
        val y: Int
)