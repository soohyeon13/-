package 백준

private var answer  = 1
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private lateinit var arr : Array<IntArray>
private lateinit var visited : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    arr = Array(n){IntArray(n)}
    visited = Array(n){IntArray(n){-1} }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            answer = Math.max(answer,dfs(i,j))
        }
    }
    println(answer)
    bw.flush()
}

private fun dfs(x:Int,y:Int) : Int {
    if (visited[x][y] != -1) return visited[x][y]
    var temp = 1
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr.size) continue
        if (arr[x][y] >= arr[nx][ny]) continue
        visited.forEach {
            println(it.contentToString())
        }
        println()
        temp = Math.max(temp, dfs(nx,ny) +1)
    }
    visited[x][y] = temp
    return visited[x][y]
}