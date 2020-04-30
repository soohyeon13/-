package 백준

private var min = Int.MAX_VALUE
private var N = 0
private var M = 0
private lateinit var copyArr: Array<IntArray>
private val cctvArr = ArrayList<CCTV>()
private val dir = arrayOf(intArrayOf(),
        intArrayOf(1),
        intArrayOf(1, 3),
        intArrayOf(0, 1),
        intArrayOf(0, 1, 3),
        intArrayOf(0, 1, 2, 3)
)
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[0]) { IntArray(n[1]) }
    N = n[0]
    M = n[1]
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
            if (row[j] in 1..5) {
                cctvArr.add(CCTV(i, j, row[j]))
            }
        }
    }
    dfs(0, arr)
    println(min)
    bw.flush()
}

private fun dfs(index: Int, arr: Array<IntArray>) {
    if (index == cctvArr.size) {
        var res = 0
        for (i in 0 until arr.size) {
            for (j in 0 until arr[0].size) {
                if (arr[i][j] == 0) res++
            }
        }
        min = Math.min(min,res)
        return
    }
    val c = cctvArr[index]
    for (i in 0 until 4) {
        val copy = arr.clone()
        for (j in 0 until dir[c.cctv].size) {
            val nd = (dir[c.cctv][j] -i +3) % 4
            var nx = c.x
            var ny = c.y
            while (true) {
                nx += dx[nd]
                ny += dy[nd]
                if (!isRange(nx,ny) || copy[nx][ny] == 6) break
                copy[nx][ny] = 7
            }
        }
        dfs(index +1 , copy)
    }
}
private fun isRange(x : Int , y : Int) : Boolean {
    if (x < 0 || x >= N || y < 0 || y >= M) return false
    return true
}
data class CCTV(
        val x: Int,
        val y: Int,
        val cctv: Int
)