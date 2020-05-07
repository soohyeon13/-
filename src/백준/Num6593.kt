package 백준

import java.util.*

private lateinit var map : Array<Array<Array<String>>>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val n = br.readLine().split(" ")
        val l = n[0].toInt()
        val r = n[1].toInt()
        val c = n[2].toInt()
        if (l == 0 && r == 0 && c == 0) break
        map = Array(l+1){ Array(r){Array(c) {""} } }
        val visited = Array(l+1){Array(r){BooleanArray(c)} }
        val start = Array<Int>(3){0}
        val end = Array<Int>(3){0}
        var cnt = 1
        loop@while (cnt  <= l) {
            for (i in 0 until r) {
                val row = br.readLine().toCharArray().map { it.toString() }
                if (row.isEmpty()) continue@loop
                for (j in row.indices) {
                    map[cnt][i][j] = row[j]
                    if (map[cnt][i][j] == "S") {
                        start[0] = cnt
                        start[1] = i
                        start[2] = j
                    }
                    if (map[cnt][i][j] == "E") {
                        end[0] = cnt
                        end[1] = i
                        end[2] = j
                    }
                }
            }
            cnt+=1
        }
        var answer =0
        visited[start[0]][start[1]][start[2]] = true
        val queue : Queue<Building> = LinkedList()
        queue.add(Building(start[0],start[1],start[2],0))
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (map[q.floor][q.x][q.y] == "E") {
                answer = q.time
                break
            }
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue
                if (visited[q.floor][nx][ny]) continue
                if (map[q.floor][nx][ny] == "." || map[q.floor][nx][ny] == "E") {
                    visited[q.floor][nx][ny] = true
                    queue.offer(Building(q.floor,nx,ny,q.time+1))
                }
            }
            if (q.floor+1 <=l) {
                if ((map[q.floor+1][q.x][q.y] == "." || map[q.floor+1][q.x][q.y] == "E")&& !visited[q.floor+1][q.x][q.y]) {
                    visited[q.floor+1][q.x][q.y] = true
                    queue.offer(Building(q.floor+1,q.x,q.y,q.time+1))
                }
            }
            if (q.floor -1 >=1) {
                if ((map[q.floor-1][q.x][q.y] == "." || map[q.floor-1][q.x][q.y] == "E")&& !visited[q.floor-1][q.x][q.y]) {
                    visited[q.floor-1][q.x][q.y] = true
                    queue.offer(Building(q.floor-1,q.x,q.y,q.time+1))
                }
            }
        }
        if (answer ==0) println("Trapped!")
        else println("Escaped in $answer minute(s).")
        val a = br.readLine()
    }

    bw.flush()
}

private data class Building(
        val floor : Int,
        val x : Int,
        val y : Int,
        val time : Int
)