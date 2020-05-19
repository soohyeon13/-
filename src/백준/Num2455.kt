package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var answer = 0
    var remain = 0
    for (i in 0 until 4) {
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        remain = remain - a + b
        if (answer < remain) answer = remain
    }
    println(answer)
    bw.flush()
}