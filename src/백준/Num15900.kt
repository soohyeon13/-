package 백준

private lateinit var treeMap: Array<ArrayList<Int>>
private lateinit var visited : BooleanArray
private var sum = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    treeMap = Array(N + 1) { ArrayList<Int>() }
    visited = BooleanArray(N+1)
    for (i in 0 until N - 1) {
        val row = input.readLine().split(" ").map { it.toInt() }
        treeMap[row[0]].add(row[1])
        treeMap[row[1]].add(row[0])
    }
    dfs(1,0)
    if (sum % 2 ==0) println("No")
    else println("Yes")
}

private fun dfs(index:Int,r :Int) {
    visited[index] = true
    var flag = false
    for (i in treeMap[index].indices) {
        val node = treeMap[index][i]
        if (!visited[node]){
            flag = true
            dfs(node,r+1)
        }
    }
    if (!flag) sum += r
}