package 백준

import java.util.*

private lateinit var map: Array<IntArray>
private val topClean = IntArray(2)
private val bottomClean = IntArray(2)
private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)
private val bottomDir = intArrayOf(0, 3, 2, 1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r, c, t) = br.readLine().split(" ").map { it.toInt() }
    map = Array(r) { IntArray(c) }
    var check = true
    for (i in 0 until r) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
            if (row[j] == -1) {
                if (check) {
                    topClean[0] = i
                    topClean[1] = j
                    check = false
                } else {
                    bottomClean[0] = i
                    bottomClean[1] = j
                }
            }
        }
    }
    for (T in 0 until t) {
        diffusion()
        println("확산")
        for (i in map.indices) {
            println(map[i].contentToString())
        }
        println("*********************")
        topCleaning()
        bottomCleaning()
        println("움직임")
        for (i in map.indices) {
            println(map[i].contentToString())
        }
        println("*********************")
    }
    var answer = 0
    for (i in map.indices) {
        println(map[i].contentToString())
        for (j in map[0].indices) {
            if (map[i][j] >0) answer += map[i][j]
        }
    }
    println(answer)
}
private fun topCleaning() {
    var nx = topClean[0]
    var ny = topClean[1]
    var save = 0
    var b = 0
    loop@for (i in 0 until 4) {
        while (true) {
            nx += dx[i]
            ny += dy[i]
            if (nx < 0 || ny <0 || nx >= map.size || ny>=map[0].size) {
                nx -= dx[i]
                ny -= dy[i]
                continue@loop
            }
            if (map[nx][ny] == -1)  {
                if (save != 0) map[nx-dx[i]][ny-dy[i]] = 0
                break@loop
            }
            b = map[nx][ny]
            map[nx][ny] = save
            save = b
        }
    }
}
private fun bottomCleaning() {
    var nx = bottomClean[0]
    var ny = bottomClean[1]
    var save = 0
    var b = 0
    loop@for (i in 0 until 4) {
        while (true) {
            nx += dx[bottomDir[i]]
            ny += dy[bottomDir[i]]
            if (nx < 0 || ny <0 || nx >= map.size || ny>=map[0].size) {
                nx -= dx[bottomDir[i]]
                ny -= dy[bottomDir[i]]
                continue@loop
            }
            if (map[nx][ny] == -1)  {
                if (save != 0) map[nx-dx[bottomDir[i]]][ny-dy[bottomDir[i]]] = 0
                break@loop
            }
            b = map[nx][ny]
            map[nx][ny] = save
            save = b
        }
    }
}

private fun diffusion() {
    val queue: Queue<Dust> = LinkedList()
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] > 4) {
                queue.offer(Dust(i, j, map[i][j]))
            }
        }
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val expansion = q.dust / 5
        var cnt = 0
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
            if (map[nx][ny] == -1) continue
            map[nx][ny] += expansion
            cnt++
        }
        map[q.x][q.y] -= expansion*cnt
    }
}

private data class Dust(
        val x: Int,
        val y: Int,
        val dust: Int
)























