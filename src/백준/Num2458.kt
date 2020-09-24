package 백준

private lateinit var sequenceMap: Array<Array<ArrayList<Int>>>
private lateinit var visited: BooleanArray
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    sequenceMap = Array(2) { Array(N + 1) { ArrayList<Int>() } }
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        sequenceMap[0][row[0]].add(row[1])
        sequenceMap[1][row[1]].add(row[0])
    }
    var answer = 0
    for (i in 1..N) {
        visited = BooleanArray(N + 1)
        val bigSum = dfs(0,i)
        val smallSum = dfs(1,i)
        if (bigSum + smallSum - 2 == N - 1) answer++
    }
    println(answer)
}

private fun dfs(index: Int, n: Int): Int {
    var cnt = 1
    visited[n] = true
    for (i in sequenceMap[index][n].indices) {
        val node = sequenceMap[index][n][i]
        if (!visited[node]) cnt+= dfs(index,node)
    }
    return cnt
}