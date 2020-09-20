package 백준

private lateinit var parent: IntArray
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M) = input.readLine().split(" ").map { it.toInt() }
    val loadInfos = ArrayList<SchoolPath>()
    for (i in 0 until M + 1) {
        val row = input.readLine().split(" ").map { it.toInt() }
        loadInfos.add(SchoolPath(row[0], row[1], row[2]))
    }
    parent = IntArray(N + 1) { i -> i }
    loadInfos.sortBy { it.cost }
    var cost1 = 0
    for (i in loadInfos.indices) {
        val path = loadInfos[i]
        if (find(path.start) != find(path.end)) {
            union(path.start,path.end)
            if (path.cost == 0) cost1++
        }
    }
    parent = IntArray(N + 1) { i -> i }
    var cost2 = 0
    for (i in loadInfos.size-1 downTo  0 step 1) {
        val path = loadInfos[i]
        if (find(path.start) != find(path.end)) {
            union(path.start,path.end)
            if (path.cost == 0) cost2++
        }
    }
    val answer = cost1 * cost1 - cost2*cost2
    println(answer)
}

private fun find(x: Int): Int {
    if (x == parent[x]) return x
    else {
        parent[x] = find(parent[x])
        return parent[x]
    }
}

private fun union(x: Int, y: Int) {
    val xx = find(x)
    val yy = find(y)
    if (xx != yy) {
        parent[yy] = xx
    }
}


private data class SchoolPath(
        val start: Int,
        val end: Int,
        val cost: Int
)