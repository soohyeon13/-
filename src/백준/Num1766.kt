package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    val problems = Array(N + 1) { ArrayList<Int>() }
    val node = IntArray(N + 1)
    val answer = StringBuilder()
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        problems[row[0]].add(row[1])
        node[row[1]]++
    }
    val pq = PriorityQueue<Int>()
    for (i in 1..N) {
        if (node[i] == 0) pq.offer(i)
    }
    while (!pq.isEmpty()) {
        val q = pq.poll()
        for (i in problems[q].indices) {
            node[problems[q][i]]--
            if (node[problems[q][i]] == 0)
                pq.offer(problems[q][i])
        }
        answer.append(q).append(" ")
    }
    println(answer.trim())
}


