package 백준


private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var campMap: Array<Array<String>>
private val visited = Array(5){BooleanArray(5)}
private var r = 0
private var c = 0
private var k = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (R, C, K) = input.readLine().split(" ").map { it.toInt() }
    campMap = Array(R) { Array(C) { " " } }
    r = R
    c = C
    k = K
    for (i in 0 until R) {
        val row = input.readLine().toCharArray().map { it.toString() }
        campMap[i] = row.toTypedArray()
    }
    campMap[0][C - 1] = "H"
    val answer = dfs(R - 1, 0, 1)
    println(answer)
}

private fun dfs(x: Int, y: Int, dist: Int): Int {
    if (dist == k) {
        if (campMap[x][y] == "H") return 1
        else 0
    }
    visited[x][y] = true
    var count = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue
        if (campMap[nx][ny] == "T") continue
        if (visited[nx][ny]) continue
        count += dfs(nx,ny,dist+1)
    }
    visited[x][y] = false
    return count
}

