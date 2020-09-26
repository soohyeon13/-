package 백준


private lateinit var flowerMap: Array<IntArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var answer = Int.MAX_VALUE
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    n = N
    var num = 0
    val flowerNumbers = IntArray(N * N) { num++ }
    val visited = BooleanArray(N * N)
    flowerMap = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }.toIntArray()
        flowerMap[i] = row
    }
    comb(flowerNumbers, visited, 0, flowerNumbers.size, 3)
    println(answer)
}

private fun comb(arr: IntArray, visited: BooleanArray, start: Int, size: Int, r: Int) {
    if (r == 0) {
        val flowers = ArrayList<Int>()
        for (i in visited.indices) {
            if (visited[i]) flowers.add(i)
        }
        calculateCost(flowers.toIntArray())
        return
    }

    for (i in start until size) {
        visited[i] = true
        comb(arr, visited, i + 1, size, r - 1)
        visited[i] = false
    }
}

private fun calculateCost(flowers: IntArray) {
    var cost = 0
    val visited = Array(n) { BooleanArray(n) }
    for (i in flowers.indices) {
        val x = flowers[i] / n
        val y = flowers[i] % n
        visited[x][y] = true
        cost += flowerMap[x][y]
        for (j in 0 until 4) {
            val nx = x + dx[j]
            val ny = y + dy[j]
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return
            if (visited[nx][ny]) return
            visited[nx][ny] = true
            cost += flowerMap[nx][ny]
        }
    }
    if (answer > cost) answer = cost
}

