package 백준

private val set = mutableSetOf<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map {it.toInt()}
    val arr = Array(n[0] +1) { IntArray(n[0] +1) { 0 } }
    val visited = Array(n[0]+1){false}
    for (i in 0 until n[1]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            if (arr[row[0]][row[1]] < row[2]) {
                arr[row[0]][row[1]] = row[2]
                arr[row[1]][row[0]] = row[2]
            }
        }
    }
    val se = br.readLine().split(" ").map{it.toInt()}
    visited[1] = true
    dfs(arr,se[0],se[1],Int.MAX_VALUE,visited)
    var left : Long= 1
    var right : Long= 1000000000
    var answer : Long= 0
    while (left <= right) {
        val mid = (left + right)/2
        var flag = false
        for (element in set) {
            if (element >= mid) {
                flag = true
                break
            }
        }
        if (flag) {
            left = mid +1
            answer = if (answer < mid) mid else answer
        }else {
            right = mid -1
        }
    }
    println(answer)
    bw.flush()
}
private fun dfs(arr : Array<IntArray>,start : Int, end : Int, co : Int, visited : Array<Boolean>) {
    if (start == end) {
        set.add(co)
        return
    }
    for (i in 1 until  arr.size) {
        if (arr[start][i] != 0 && !visited[i])  {
            visited[i] = true
            val c = if(co > arr[start][i]) arr[start][i] else co
            dfs(arr,i,end,c,visited)
            visited[i] = false
        }
    }
}