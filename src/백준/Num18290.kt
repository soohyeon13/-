package 백준

private lateinit var numberMap: Array<IntArray>
private lateinit var indexMap: IntArray
private var maxValue = Int.MIN_VALUE
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var m = 0

fun main() {
    val input = System.`in`.bufferedReader()
    val (N, M, K) = input.readLine().split(" ").map { it.toInt() }
    var number = 0
    n = N
    m = M
    indexMap = IntArray(N * M) { number++ }
    numberMap = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        numberMap[i] = row.toIntArray()
    }
    val visited = BooleanArray(N * M)
    combination(visited, 0, K)
    println(maxValue)
}

private fun combination(visited: BooleanArray, start: Int, r: Int) {
    if (r == 0) {
        val arr = ArrayList<Int>()
        visited.forEachIndexed { index, value -> if (value) arr.add(index) }
        calculate(arr)
        return
    }
    loop@ for (i in start until indexMap.size) {
        visited[i] = true
        if (!isCheckStuck(visited, i)) {
            visited[i] = false
            continue@loop
        }
        combination(visited, i + 1, r - 1)
        visited[i] = false
    }
}

private fun isCheckStuck(visited: BooleanArray, index: Int): Boolean {
    val x = index / m
    val y = index % m
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
        val n = nx * m + ny
        if (visited[n])
            return false
    }
    return true
}

private fun calculate(arr: ArrayList<Int>) {
    var count = 0
    for (i in arr.indices) {
        val x = arr[i] / m
        val y = arr[i] % m
        count += numberMap[x][y]
    }
    if (maxValue < count) maxValue = count
}