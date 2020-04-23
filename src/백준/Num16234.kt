package 백준

import java.util.*
import kotlin.collections.ArrayList

private val ny = intArrayOf(0,0,-1,1)
private val nx = intArrayOf(-1,1,0,0)
private lateinit var copyArr : Array<IntArray>
private lateinit var visited : Array<BooleanArray>
private val sumArr = ArrayList<IntArray>()
private var sum = 0
private var cnt = 0
private var c = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val NLR = br.readLine().split(" ").map { it.toInt() }
    val N = NLR[0]
    val L = NLR[1]
    val R = NLR[2]
    val arr = Array(N){IntArray(N)}
    for (i in 0 until N) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until N) {
            arr[i][j] = row[j]
        }
    }
    var answer = 0
    while (true){
        copyArr = Array(N){ IntArray(N) }
        visited = Array(N){ BooleanArray(N) }
        c= 1
        for (i in 0 until N) {
            for (j in 0 until N)  {
                if (copyArr[i][j] == 0) {
                    sum = arr[i][j]
                    sumArr.add(intArrayOf(i,j))
                    cnt =1
                    dfs(i,j,NLR,arr)
                    c++
                    if (cnt >1) {
                        for (k in sumArr.indices) {
                            arr[sumArr[k][0]][sumArr[k][1]] = sum/ cnt
                        }
                    }
                }
                sumArr.clear()
            }
        }
        val cnt = IntArray(--c)
        if (cnt.size == N * N) break
        answer++
    }
    println(answer)
    bw.flush()
}
private fun dfs(y:Int,x:Int,NLR:List<Int>,arr:Array<IntArray>) {
    val n = NLR[0]
    val l = NLR[1]
    val r = NLR[2]
    copyArr[y][x] = c
    visited[y][x] = true
    for (i in 0 until 4) {
        val dy = y + ny[i]
        val dx = x + nx[i]
        if (dx >= 0 && dy >=0 && dx < n && dy < n) {
            val sub = Math.abs(arr[y][x] - arr[dy][dx])
            if (sub in l..r && !visited[dy][dx]) {
                cnt++
                sum += arr[dy][dx]
                sumArr.add(intArrayOf(dy,dx))
                dfs(dy,dx,NLR,arr)
            }
        }
    }
}

private fun bfs(y: Int,x: Int,NLR:List<Int>,arr:Array<IntArray>) {
    val n = NLR[0]
    val l = NLR[1]
    val r = NLR[2]
    val queue :Queue<Country> = LinkedList()
    val country = Country(y,x)
    while (!queue.isEmpty()) {
        val a = queue.poll()
        copyArr[a.y][a.x] = c
        visited[a.y][a.x] = true
        for (i in 0 until 4) {
            val ny = a.y + ny[i]
            val nx = a.x + nx[i]
            if (ny >=0 && nx >= 0 && ny< n && nx < n) {
                val k = Math.abs(arr[a.y][a.x] - arr[ny][nx])
                if (k in l..r && !visited[ny][nx]) {
                    queue.add(Country(ny,nx))
                    visited[ny][nx] = true
                }
            }
        }
    }
}

data class Country(
        var y : Int,
        var x : Int
)