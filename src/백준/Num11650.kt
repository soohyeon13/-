package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val queue : PriorityQueue<DotSort> =
            PriorityQueue(Comparator<DotSort>{p0,p1 ->
                if (p0.y < p1.y) -1
                else if (p0.y == p1.y) {
                    if (p0.x > p1.x) 1
                    else -1
                }else 1
            })
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map{it.toInt()}
        queue.add(DotSort(row[0],row[1]))
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        println("${q.x} ${q.y}")
    }
    bw.flush()
}
data class DotSort(
        val x : Int,
        val y: Int
)