package 백준

private lateinit var arr: Array<IntArray>
private var answer = 0
private var N = 0
private val dy = intArrayOf(1, 0, 1)
private val dx = intArrayOf(0, 1, 1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    N = cnt
    arr = Array(cnt) { IntArray(cnt) }
    for (i in arr.indices) {
        val row = br.readLine().split(" ")
        for (j in row.indices) {
            arr[i][j] = row[j].toInt()
        }
    }
    dfs(0, 1, 1)
    println(answer)
    bw.flush()
}

private fun getDir(type: Int): IntArray? {
    if (type == 0) return intArrayOf(0, 2)
    if (type == 1) return intArrayOf(1, 2)
    if (type == 2) return intArrayOf(0, 1, 2)
    return null
}

private fun dfs(y: Int, x: Int, pipe: Int) {
    println("y : $y , x :$x")
    if (x == N - 1 && y == N - 1) {
        answer += 1
        return
    }
    val Dir = getDir(pipe)!!
    for (i in Dir.indices) {
        val ny = y+ dy[Dir[i]]
        val nx = x + dx[Dir[i]]
        println("ny : $ny , nx : $nx")
        if (ny < 0 || ny>N-1 || nx < 0 || nx>N-1 || arr[ny][nx] != 0) continue
        if (Dir[i] == 2 && (arr[y][x+1] !=  0 || arr[y+1][x] != 0)) continue
        dfs(ny,nx,Dir[i])
    }
}