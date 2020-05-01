package 백준

private var n = 0
private var m = 0
private var h = 0
private var answer = 0
private var finish = false
private lateinit var map: Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val list = br.readLine().split(" ").map { it.toInt() }
    n = list[0]
    m = list[1]
    h = list[2]
    map = Array(h + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]][row[1]] = 1
        map[row[0]][row[1] + 1] = 2
    }
    map.forEach { println(it.contentToString()) }
    for (i in 0..3) {
        answer = i
        dfs(1, 0)
        if (finish) break
    }
    if (finish) answer
    else -1
}

private fun dfs(x: Int, count: Int) {
    if (finish) return
    if (answer == count) {
        if (check()) finish = true
        return
    }
    for (i in x until h+1) {
        for (j in 1 until n) {
            if (map[i][j] == 0 && map[i][j+1] == 0) {
                map[i][j] = 1
                map[i][j+1] = 2
                dfs(i,count+1)
                map[i][j] = 0
                map[i][j+1] = 0
            }
        }
    }
}

private fun check(): Boolean {
    for (i in 1..n) {
        var x = 1
        var y = i
        for (j in 0 until h) {
            if (map[x][y] == 1) y++
            else if (map[x][y] == 2) y--
            x++
        }
        if (y != i) return false
    }
    return true
}