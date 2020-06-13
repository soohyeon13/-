package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

private lateinit var map : Array<IntArray>
private lateinit var copyMap : Array<IntArray>
private lateinit var streetVisited : Array<BooleanArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var answer =Int.MAX_VALUE
private var distance = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n){ IntArray(n) }
    copyMap = Array(n){ IntArray(n) }
    val chickens = ArrayList<Chicken>()
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
            if (row[j] == 2) {
                chickens.add(Chicken(i,j))
                map[i][j] = 0
            }
        }
    }
    val visited = BooleanArray(chickens.size)
    comb(chickens,visited,0,0,m)
    println(answer)
    bw.flush()
}

private fun comb(ch : ArrayList<Chicken>,visited : BooleanArray,start : Int , depth : Int,m : Int) {
    if (depth == m ) {
        copy()
        distance = 0
        for (i in visited.indices) {
            if (visited[i]) {
                copyMap[ch[i].x][ch[i].y] = 2
            }
        }
        for (i in copyMap.indices) {
            for (j in copyMap[i].indices) {
                if (copyMap[i][j] == 1) {
                    bfs(i,j)
                }
            }
        }
        answer = min(answer, distance)
        return
    }
    for (i in start until ch.size) {
        visited[i] = true
        comb(ch,visited,i+1,depth+1,m)
        visited[i] = false
    }
}

private fun bfs(x : Int, y : Int) {
    streetVisited = Array(map.size){ BooleanArray(map.size) }
    val queue : Queue<Street> = LinkedList()
    queue.offer(Street(x,y))
    streetVisited[x][y] = true
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (copyMap[q.x][q.y] == 2) {
            distance += abs(q.x - x) + abs(q.y -y)
            break
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx>= copyMap.size || ny>= copyMap.size) continue
            if (streetVisited[nx][ny]) continue
            queue.offer(Street(nx,ny))
            streetVisited[nx][ny] = true
        }
    }
}

private fun copy() {
    for (i in map.indices) {
        for (j in map[i].indices) {
            copyMap[i][j] = map[i][j]
        }
    }
}
private data class Street(
        val x : Int,
        val y : Int
)

private data class Chicken(
        val x : Int,
        val y : Int
)