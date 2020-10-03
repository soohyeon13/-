package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var visited: BooleanArray
private lateinit var finished: BooleanArray
private lateinit var musicMap : Array<ArrayList<Int>>
private val stack = Stack<Int>()
private var answer = true
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    musicMap = Array(N + 1) { ArrayList<Int>() }
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        if (row[0] <= 0) continue
        for (j in 1 until row.size - 1) {
            musicMap[row[j]].add(row[j + 1])
        }
    }
    visited = BooleanArray(N + 1)
    finished = BooleanArray(N + 1)
    for (i in 1..N) {
        if (finished[i]) continue
        dfs(i)
        if(!answer) {
            println(0)
            return
        }
    }
    while (!stack.isEmpty()) {
        println(stack.pop())
    }
}

private fun dfs(v: Int) {
    if (visited[v]) {
        answer = false
        return
    }
    if (finished[v]) return
    visited[v] = true
    while (!musicMap[v].isEmpty()) {
        val nNode = musicMap[v].removeAt(0)
        dfs(nNode)
    }
    stack.push(v)
    finished[v] = true
    visited[v] = false
}