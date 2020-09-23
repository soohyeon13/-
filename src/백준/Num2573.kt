package 백준

private lateinit var iceMap: Array<IntArray>
private lateinit var melt: Array<IntArray>
private lateinit var visited: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    iceMap = Array(N) { IntArray(M) }
    melt = Array(N) { IntArray(M) }
    visited = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            iceMap[i][j] = row[j]
        }
    }
    var year = 0
    while (true) {
        var count = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (visited[i][j] == 0 && iceMap[i][j] != 0) {
                    dfs(i, j, N, M)
                    count++
                }
            }
        }
        if (count == 0) {
            println(0)
            break
        } else if (count >= 2) {
            println(year)
            break
        }
        melting(N, M)
        year++
    }
}

private fun dfs(x: Int, y: Int, n: Int, m: Int) {
    visited[x][y] = 1
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until n && ny in 0 until m) {
            if (iceMap[nx][ny] == 0) melt[x][y]++
            if (visited[nx][ny] == 0 && iceMap[nx][ny] != 0) {
                dfs(nx, ny, n, m)
            }
        }
    }
}

private fun melting(n: Int, m: Int) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            iceMap[i][j] -= melt[i][j]
            if (iceMap[i][j] < 0) iceMap[i][j] = 0
            visited[i][j] = 0
            melt[i][j] = 0
        }
    }
}