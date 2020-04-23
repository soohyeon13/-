package 백준

import java.util.*

private lateinit var arr: Array<Array<String>>
private val wallQueue: Queue<Wall> = LinkedList()
private var answer = false
private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    arr = Array(8) { Array(8) { "" } }
    for (i in 0 until 8) {
        val row = br.readLine().toCharArray()
        for (j in 0 until 8) {
            arr[i][j] = row[j].toString()
            if (row[j] == '#') {
                wallQueue.add(Wall(i, j))
            }
        }
    }
    if (wallQueue.size == 0) println(0)
    else bfs(7, 0)
    if (answer) println(1)
    else println(0)
}

private fun bfs(x: Int, y: Int) {
    val queue: Queue<Escape> = LinkedList()
    queue.add(Escape(x, y))
    loop@while (true) {
        if (queue.size == 0) {
            break
        }
        if (wallQueue.size == 0) {
            answer = true
            break
        }
        val qSize = queue.size
        for (t in 0 until qSize) {
            val q = queue.poll()
            for (i in 0 until 8) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue
                if (arr[nx][ny] == "#") continue
                queue.add(Escape(nx, ny))
                if (nx == 0) {
                    answer = true
                    break@loop
                }
            }
        }
        for (i in 0 until wallQueue.size) {
            val w = wallQueue.poll()
            val wnx = w.x + 1
            val wny = w.y
            if (wnx >= 8) {
                arr[w.x][w.y] = "."
                continue
            }
            if (queue.contains(Escape(wnx, wny))) {
                queue.remove(Escape(wnx, wny))
            } else {
                arr[w.x][w.y] = "."
                wallQueue.add(Wall(wnx, wny))
            }
            wallQueue.add(Wall(wnx, wny))
            arr[wnx][wny] = "#"
        }
    }
}

data class Wall(
        val x: Int,
        val y: Int
)

data class Escape(
        val x: Int,
        val y: Int
)