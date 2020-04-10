package 백준

import java.util.*

data class Meeting(
        val start: Int,
        val end: Int
)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    val queue: PriorityQueue<Meeting> = PriorityQueue()
    for (i in 0 until cnt) {
        val time = br.readLine().split(" ")
    }
}