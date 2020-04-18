package 백준

import java.util.*

private lateinit var arr : Array<IntArray>
private lateinit var visit : BooleanArray
private var n = 0
private var t = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    n = br.readLine().toInt()
    arr = Array(n+1){ IntArray(n+1) }
    visit = BooleanArray(n+1)
    t = br.readLine().toInt()
    for (i in 0 until t) {
        val temp = br.readLine().split(" ")
        val a = temp[0].toInt()
        val b = temp[1].toInt()
        arr[a][b] = 1
        arr[b][a] = 1
    }
    println(bfs(1))
    bw.flush()
}

private fun bfs(start: Int) : Int {
    var cnt = 0
    val queue :Queue<Int> = LinkedList()
    queue.offer(start)
    while (!queue.isEmpty()) {
        var x = queue.poll()
        visit[x] = true
        for (i in 1 .. n) {
            if (arr[x][i] == 1 && !visit[i]) {
                queue.offer(i)
                visit[i]  =true
                cnt +=1
            }
        }
    }
    return cnt
}