package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val min = PriorityQueue<Int>()
    val n = br.readLine().toInt()
    val max = PriorityQueue<Int>(reverseOrder())
    for (i in 0 until n) {
        val num = br.readLine().toInt()
        if (i == 0) {
            max.offer(num)
            println(max.peek())
            continue
        }
        if (i %2 == 0) max.offer(num)
        else min.offer(num)
        if (max.peek() > min.peek()) {
            val a = max.poll()
            val b = min.poll()
            max.offer(b)
            min.offer(a)
        }
        println(max.peek())
    }
    bw.flush()
}