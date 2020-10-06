package 백준

import kotlin.math.max

private lateinit var numberMap: Array<IntArray>
private lateinit var indexMap: IntArray
private var maxValue = Int.MIN_VALUE
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var m = 0

fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M, K) = input.readLine().split(" ").map { it.toInt() }
    var number = 0
    n = N
    m = M
    indexMap = IntArray(N * M) { number++ }
    numberMap = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        numberMap[i] = row.toIntArray()
    }
    val visited = BooleanArray(N * M)
    combination(visited, 0, K, 0)
    println(maxValue)
}

private fun combination(visited: BooleanArray, start: Int, r: Int, sum: Int) {
    if (r == 0) {
        maxValue = max(maxValue, sum)
        return
    }
    loop@ for (i in start until indexMap.size) {
        visited[i] = true
        val x = i / m
        val y = i % m
        if (!isCheckStuck(visited, x, y)) {
            visited[i] = false
            continue@loop
        }
        combination(visited, i + 1, r - 1, sum + numberMap[x][y])
        visited[i] = false
    }
}

private fun isCheckStuck(visited: BooleanArray, x: Int, y: Int): Boolean {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
        val n = nx * m + ny
        if (visited[n])
            return false
    }
    return true
}