package 백준

private var answer =0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val input = br.readLine().split(" ").map { it.toInt() }
        answer = 0
        val visited = BooleanArray(n + 1) { false }
        val arr = Array(n + 1) { IntArray(n + 1) { 0 } }
        for (j in 1 until n + 1) {
            arr[input[j - 1]][j] = 1
        }
        for (j in 1 .. n) {
            if (!visited[j]) {
                dfs(j,arr,visited,n)
            }
        }
        println(answer)
    }
    bw.flush()
}

private fun dfs(start: Int, arr: Array<IntArray>, visit: BooleanArray,n:Int) {
    visit[start] = true
    for (i in 1..n) {
        if (arr[start][i] == 1 && !visit[i]) {
            visit[i] = true
            dfs(i,arr,visit,n)
        }else if (arr[start][i] == 1 && visit[i]) {
            answer++
            return
        }
    }
}