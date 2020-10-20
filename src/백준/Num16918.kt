package 백준


fun main() {
    val input = System.`in`.bufferedReader()
    val (R, N, C) = input.readLine().split(" ").map { it.toInt() }
    val bomberMap = Array(R) { Array(N) { " " } }

    for (i in 0 until R) {
        val row = input.readLine().toCharArray().map { it.toString() }
        bomberMap[i] = row.toTypedArray()
    }

    var cnt = 1
    while (cnt < C) {
        val copyMap = Array(R) { Array(N) { "" } }
        for (i in 0 until R) {
            copyMap[i] = bomberMap[i]
        }
    }
}