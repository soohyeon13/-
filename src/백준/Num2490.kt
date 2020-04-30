package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    for (i in 0 until 3) {
        val arr = br.readLine().split(" ").map { it.toInt() }
        var check = 0
        for (j in arr.indices) {
            check += arr[j]
        }
        when (check) {
            3 -> println("A")
            2 -> println("B")
            1 -> println("C")
            0 -> println("D")
            else -> println("E")
        }
    }
    bw.flush()
}