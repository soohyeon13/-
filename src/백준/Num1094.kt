package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val x = br.readLine().toInt()
    val queue : PriorityQueue<Int> = PriorityQueue()
    queue.offer(64)
    var sum = 64
    while (sum != x) {
        if (sum > x ) {
            val q = queue.poll()
            sum = sum - q + q/2
            if (sum >= x) {
                queue.offer(q/2)
            }else {
                sum += q/2
                queue.offer(q/2)
                queue.offer(q/2)
            }
        }
    }
    println(queue.size)
    bw.flush()
}