package 백준

private val set = mutableSetOf<String>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (l, c) = br.readLine().split(" ").map { it.toInt() }
    val map = br.readLine().split(" ").toTypedArray()
    val visited = Array(c) { false }
    map.sort()
    comb(map, visited, 0, c, l)
    set.sorted().forEach { println(it) }
    bw.flush()
}

private fun comb(arr: Array<String>, visited: Array<Boolean>, start: Int, n: Int, r: Int) {
    if (r == 0) {
        val sb = StringBuilder()
        var a = 0
        var b = 0
        for (i in visited.indices) {
            if (visited[i]) {
                if (arr[i] == "a" || arr[i] == "e" || arr[i] == "i" || arr[i] == "o" || arr[i] == "u") {
                    a += 1
                } else {
                    b += 1
                }
                sb.append(arr[i])
            }
        }
        if (a >=1 && b >=2) {
            set.add(sb.toString())
        }
        return
    }
    for (i in start until n) {
        visited[i] = true
        comb(arr, visited, i + 1, n, r - 1)
        visited[i] = false
    }
}