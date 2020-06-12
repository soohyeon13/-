package 백준

import java.util.*

private var N =0
private var K =0
private lateinit var visited : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var (n,k) = br.readLine().split(" ").map { it.toInt() }
    visited = Array(2){IntArray(500001){-1} }
    visited[0][n] = 0
    N = n
    K = k
    if (n == k) println(0)
    else println(move())
    bw.flush()
}
private fun move() : Int{
    val queue : Queue<Int> = LinkedList()
    queue.offer(N)
    var len = 0
    var mod = 0
    var time = 0
    while (!queue.isEmpty()) {
        len = queue.size
        time++
        mod = time%2
        for (i in 0 until len) {
            val q = queue.poll()
            if (q-1 >=0) {
                if (visited[mod][q-1] == -1) {
                    queue.offer(q-1)
                    visited[mod][q-1] = time
                }
            }
            if (q +1 <= 500000) {
                if (visited[mod][q+1] == -1) {
                    queue.offer(q+1)
                    visited[mod][q+1] = time
                }
            }
            if (q*2 <= 500000) {
                if (visited[mod][q*2] == -1) {
                    queue.offer(q*2)
                    visited[mod][q*2] = time
                }
            }
        }
        val sis = getSis(time)
        if (sis > 500000) break
        if (visited[mod][sis] != -1) return time
    }
    return -1
}

private fun getSis(n : Int) = K + (n*(n+1)/2)