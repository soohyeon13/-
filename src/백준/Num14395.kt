package 백준

import java.util.*
import kotlin.collections.HashSet

private val dir = arrayOf("*","+","-","/")
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (s,t) = br.readLine().split(" ").map { it.toLong() }
    if (s == t) println(0)
    else bfs(s,t)
    bw.flush()
}

private fun bfs(s : Long, t : Long) {
    val queue : Queue<Cale> = LinkedList()
    val set = HashSet<Long>()
    queue.offer(Cale(s,""))
    set.add(s)
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.num == t) {
            println(q.sequence)
            return
        }
        for (i in 0 until 4) {
            val ns = calculator(q.num,i)
            if (set.contains(ns)) continue
            if (ns <1) continue
            set.add(ns)
            queue.offer(Cale(ns,q.sequence+ dir[i]))
        }
    }
    println(-1)
}
private fun calculator(n : Long, i : Int) : Long {
    return when(i) {
        0 -> n*n
        1 -> n+n
        2 -> n-n
        else -> n/n
    }
}
private fun isRange(n : Int,t: Int) : Boolean{
    return !(n <1 || n > t)
}

private data class Cale(
        val num : Long,
        val sequence : String
)