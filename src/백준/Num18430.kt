package 백준

import kotlin.math.max

private lateinit var woodStrengths: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var answer = 0
private var n = 0
private var m = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    woodStrengths = Array(N) { IntArray(M) }
    visited = Array(N) { BooleanArray(M) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        woodStrengths[i] = row.toIntArray()
    }
    dfs(0, 0, 0)
    println(answer)
}

private fun dfs(x: Int, y: Int, sum: Int) {
    var copyX = x
    var copyY = y
    if (copyX == n - 1 && copyY == m) {
        answer = max(answer, sum)
        return
    }
    if (y == m) {
        copyX++
        copyY = 0
    }
    if (!visited[copyX][copyY]) {
        if (isCheckRange(copyX - 1, copyY)) {
            if (isCheckRange(copyX, copyY - 1)) {
                if (!visited[copyX - 1][copyY] && !visited[copyX][copyY - 1]) {
                    val xs = intArrayOf(copyX, copyX - 1, copyX)
                    val ys = intArrayOf(copyY, copyY, copyY - 1)
                    checkVisit(xs, ys, true)
                    val nSum = sum + calculateWood(xs, ys) + woodStrengths[copyX][copyY]
                    dfs(copyX, copyY + 1, nSum)
                    checkVisit(xs, ys, false)
                }
            }
            if (isCheckRange(copyX, copyY + 1)) {
                if (!visited[copyX - 1][copyY] && !visited[copyX][copyY + 1]) {
                    val xs = intArrayOf(copyX, copyX - 1, copyX)
                    val ys = intArrayOf(copyY, copyY, copyY + 1)
                    checkVisit(xs, ys, true)
                    val nSum = sum + calculateWood(xs, ys) + woodStrengths[copyX][copyY]
                    dfs(copyX, copyY + 1, nSum)
                    checkVisit(xs, ys, false)
                }
            }
        }

        if (isCheckRange(copyX + 1, copyY)) {
            if (isCheckRange(copyX, copyY - 1)) {
                if (!visited[copyX + 1][copyY] && !visited[copyX][copyY - 1]) {
                    val xs = intArrayOf(copyX, copyX, copyX + 1)
                    val ys = intArrayOf(copyY, copyY - 1, copyY)
                    checkVisit(xs, ys, true)
                    val nSum = sum + calculateWood(xs, ys) + woodStrengths[copyX][copyY]
                    dfs(copyX, copyY + 1, nSum)
                    checkVisit(xs, ys, false)
                }
            }
            if (isCheckRange(copyX, copyY + 1)) {
                if (!visited[copyX + 1][copyY] && !visited[copyX][copyY + 1]) {
                    val xs = intArrayOf(copyX, copyX, copyX + 1)
                    val ys = intArrayOf(copyY, copyY + 1, copyY)
                    checkVisit(xs, ys, true)
                    val nSum = sum + calculateWood(xs, ys) + woodStrengths[copyX][copyY]
                    dfs(copyX, copyY + 1, nSum)
                    checkVisit(xs, ys, false)
                }
            }
        }
    }
    dfs(copyX,copyY+1,sum)
}

private fun checkVisit(x: IntArray, y: IntArray, value: Boolean) {
    for (i in x.indices) {
        visited[x[i]][y[i]] = value
    }
}

private fun calculateWood(x: IntArray, y: IntArray): Int {
    var sum = 0
    for (i in x.indices) {
        sum += woodStrengths[x[i]][y[i]]
    }
    return sum
}

private fun isCheckRange(x: Int, y: Int): Boolean {
    return !(x < 0 || y < 0 || x >= n || y >= m)
}