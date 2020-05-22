package 윈터코딩2018

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var area: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var parent : Array<Int>
private val list = ArrayList<Area>()
private var index = -1
class LandMove {
    fun solution(land: Array<IntArray>, height: Int): Int {
        var answer = 0
        visited = Array(land.size) { BooleanArray(land[0].size) }
        area = Array(land.size) { IntArray(land[0].size) }
        for (i in land.indices) {
            for (j in land.indices) {
                if (!visited[i][j]) {
                    index +=1
                    bfs(i,j,land,height)
                }
            }
        }
        parent = Array(index+1) { i -> i}
        for (i in area.indices) {
            for (j in area.indices) {
                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (nx < 0 || ny<0 || nx >= area.size || ny >= area[0].size) continue
                    if (area[i][j] != area[nx][ny]) {
                        val diff = Math.abs(land[i][j] - land[nx][ny])
                        list.add(Area(area[i][j], area[nx][ny],diff))
                    }
                }
            }
        }
        val sort =list.sortedWith(Comparator<Area>{p0,p1 ->
            if (p0.diff < p1.diff) -1
            else if (p0.diff == p1.diff) {
                if (p0.first < p1.first) -1
                else 1
            }else 1
        })
        println(list.toString())
        var cnt = 0
        for (element in sort) {
            if (findParent(element.first) != findParent(element.second)) {
                union(element.first,element.second)
                answer += element.diff
                if (++cnt == index) break
            }
        }
        return answer
    }
}
private fun findParent(value : Int) : Int {
    if (value == parent[value]) return value
    return findParent(parent[value])
}
private fun union(first : Int, second : Int) {
    val f = findParent(first)
    val s = findParent(second)
    if (f < s) parent[s] = f
    else parent[f] = s
}
private fun bfs(x: Int, y: Int, land: Array<IntArray>, height: Int) {
    val queue: Queue<Land> = LinkedList()
    queue.offer(Land(x, y))
    visited[x][y] = true
    area[x][y] = index
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= land.size || ny >= land[0].size) continue
            if (Math.abs(land[q.x][q.y] - land[nx][ny]) > height) continue
            if (visited[nx][ny]) continue
            queue.offer(Land(nx, ny))
            visited[nx][ny] = true
            area[nx][ny] = index
        }
    }
}

private data class Area(
        val first : Int,
        val second : Int,
        val diff : Int
)
private data class Land(
        val x: Int,
        val y: Int
)
fun main() {
    val sol = LandMove()
    val a = arrayOf(intArrayOf(10, 11, 10, 11),intArrayOf(2, 21, 20, 10),
            intArrayOf(1, 20, 21, 11),intArrayOf(2, 1, 2, 1))
    println(sol.solution(a,1))
}