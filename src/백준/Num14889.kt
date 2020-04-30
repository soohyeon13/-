package 백준

private lateinit var player : IntArray
private lateinit var arr : Array<IntArray>
private lateinit var visited : BooleanArray
private lateinit var set : IntArray
private var r = 0
private var n = 0
private var min = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    n = br.readLine().toInt()
    arr = Array(n) { IntArray(n) }
    player = IntArray(n) { i -> i }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    r = n/2
    set = IntArray(r)
    combination(0,0)
    println(min)
    bw.flush()
}
private fun combination(len : Int, k : Int) {
    if (len == r) {
        println("len == r ${set.contentToString()}")
        visited = BooleanArray(n)
        for (i in set.indices) {
            visited[set[i]] = true
        }
        var start = 0
        var link = 0
        for (i in visited.indices) {
            if (visited[i]) {
                for (j in visited.indices) {
                    if (i == j) continue
                    if (visited[j]) {
                        start += arr[i][j]
                    }
                }
            }else {
                for (j in visited.indices) {
                    if (i == j) continue
                    if (!visited[j]) {
                        link += arr[i][j]
                    }
                }
            }
        }
        val res = Math.abs(start-link)
        if (min > res) min = res
        return
    }
    if (k == n) return
    set[len] = player[k]
    combination(len+1,k+1)
    println(set.contentToString())
    combination(len,k+1)
}