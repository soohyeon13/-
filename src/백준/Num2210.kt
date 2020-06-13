package 백준

import kotlin.collections.HashSet

private val map = Array(5) {Array<String>(5){""} }
private val answer = HashSet<String>()
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    for (i in 0 until 5) {
        val row = br.readLine().split(" ")
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    for (i in map.indices) {
        for (j in map[i].indices) {
            dfs(i,j,1,map[i][j])
        }
    }
    println(answer.size)
    bw.flush()
}
private fun dfs(x : Int , y : Int ,depth : Int, word : String) {
    if (depth == 6){
        answer.add(word)
        return
    }
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx>= 5 || ny>=5) continue
        dfs(nx,ny,depth +1 ,word+map[nx][ny])
    }
}