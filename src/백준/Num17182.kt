package 백준

import kotlin.math.min

private lateinit var spaceMap: Array<IntArray>
private var answer = Int.MAX_VALUE
private var n = 0
private var k = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, K) = input.readLine().split(" ").map { it.toInt() }
    n = N
    k = K
    spaceMap = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        val row = input
                .readLine()
                .split(" ")
                .map { it.toInt() }
                .toIntArray()
        spaceMap[i] = row
    }

    floydWarshall()
    val visited = BooleanArray(N)
    perm(visited, 0, K, 0)
    println(answer)
}

private fun floydWarshall() {
    for (k in 0 until n) {
        for (i in 0 until n) {
            if (i == k) continue
            for (j in 0 until n) {
                if (i == j || k == j) continue
                spaceMap[i][j] = min(spaceMap[i][j], spaceMap[i][k] + spaceMap[k][j])
            }
        }
    }
}

private fun perm(visited: BooleanArray, r: Int, k: Int, sum: Int) {
    if (sum > answer) return
    if (r == n - 1) {
        if (answer > sum) answer = sum
    } else {
        for (i in 0 until n) {
            if (i != k && !visited[i]) {
                visited[i] = true
                perm(visited, r + 1, i, sum + spaceMap[k][i])
                visited[i] = false
            }
        }
    }
}