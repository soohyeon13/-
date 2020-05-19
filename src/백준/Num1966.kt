package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val (n,m) = br.readLine().split(" ").map { it.toInt() }
        val arr= br.readLine().split(" ").map { it.toInt() }
        val queue : Queue<Print> = LinkedList()
        for (j in arr.indices) {
            queue.offer(Print(j,arr[j]))
        }
        val sortArr =arr.sortedDescending()
        var index = 0
        var printIndex =0
        while (true) {
            val q = queue.poll()
            if (q.num < sortArr[index]) {
                queue.offer(q)
            }else {
                index +=1
                printIndex +=1
                if (q.position == m) {
                    println(printIndex)
                    break
                }
            }
        }
    }
    bw.flush()
}
private data class Print(
        val position : Int,
        val num : Int
)