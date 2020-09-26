package 백준

import kotlin.collections.ArrayList

private lateinit var visited: BooleanArray
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M, X) = input.readLine().split(" ").map { it.toInt() }
    val rankMap = Array(N+1){ ArrayList<Int>() }
    val reversMap = Array(N+1){ ArrayList<Int>() }
    visited = BooleanArray(N+1)
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        rankMap[row[0]].add(row[1])
        reversMap[row[1]].add(row[0])
    }
    val a =N -(dfs(X, rankMap)-1)
    val b = (dfs(X,reversMap) -1) +1
    println("$b $a")
}

private fun dfs(index:Int,map : Array<ArrayList<Int>>):Int {
    var r = 1
    visited[index] = true
    for (i in map[index].indices) {
        val a = map[index][i]
        if (!visited[a]) r += dfs(a,map)
    }
    return r
}