package 백준

import java.util.*

private val answer = StringBuilder()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val v = n[2]
    val arr = Array(n[0] +1){IntArray(n[0]+1){0} }
    val visited = BooleanArray(n[0]+1) {false}
    for (i in 0 until n[1]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        arr[row[0]][row[1]] =1
        arr[row[1]][row[0]] = 1
    }
    visited[v] = true
    dfs(0,v,arr,visited)
    println(answer.toString())
    answer.clear()
    visited.fill(false,0,visited.size)
    bfs(v,visited,arr)
    println(answer.toString())
    bw.flush()
}
private fun bfs(start : Int,visted : BooleanArray,arr: Array<IntArray>) {
    val queue : Queue<Int> = LinkedList()
    queue.add(start)
    visted[start] = true
    while (!queue.isEmpty())  {
        val q = queue.poll()
        answer.append(q.toString()).append(" ")
        for (i in 1 until arr.size) {
            if (arr[q][i] == 1 && !visted[i]) {
                queue.add(i)
                visted[i] = true
            }
        }
    }

}

private fun dfs(depth : Int,start : Int ,arr : Array<IntArray>,visited : BooleanArray) {
    if (depth == arr.size-2) {
        answer.append(start.toString())
        return
    }
    answer.append(start.toString()).append(" ")
    for (i in 1 until arr.size) {
        if (arr[start][i] == 1 && !visited[i]) {
            visited[i] = true
            dfs(depth+1,i,arr,visited)
        }
    }
}
