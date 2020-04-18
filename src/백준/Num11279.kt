package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val queue  = PriorityQueue<Int>(reverseOrder())
    for (i in 0 until n) {
        val a = br.readLine().toInt()
        if (a == 0){
            if (queue.isEmpty()) println(0)
            else println(queue.poll())
        } else{
            queue.offer(a)
        }
    }
    bw.flush()
}